package com.ipartek.formacion.banco.servicios;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

import com.ipartek.formacion.banco.accesodatos.AccesoDatosException;
import com.ipartek.formacion.banco.accesodatos.BancoDAOMySQL;
import com.ipartek.formacion.banco.entidades.Cuenta;
import com.ipartek.formacion.banco.entidades.Importe;
import com.ipartek.formacion.banco.entidades.Movimiento;

public class ServiciosBancariosImpl implements ServiciosBancarios {

	private static final boolean REINTEGRO = false;
	private static final boolean INGRESO = true;

	@Override
	public void ingreso(Long idCuenta, String concepto, BigDecimal cantidad, String divisa) {
		crearMovimientoEnCuenta(INGRESO, idCuenta, concepto, cantidad, divisa);
	}

	@Override
	public void reintegro(Long idCuenta, String concepto, BigDecimal cantidad, String divisa) {
		crearMovimientoEnCuenta(REINTEGRO, idCuenta, concepto, cantidad, divisa);
	}
	
	private void crearMovimientoEnCuenta(boolean ingreso, Long idCuenta, String concepto, BigDecimal cantidad, String divisa) {
		
		if(cantidad.compareTo(new BigDecimal(0)) < 0) {
			throw new ServiciosBancariosException("No se puede hacer una operación de importe negativo");
		}
		
		crearMovimientoEnCuenta(idCuenta, concepto, ingreso ? cantidad : cantidad.multiply(new BigDecimal(-1)), divisa);
	}
	
	private void crearMovimientoEnCuenta(Long idCuenta, String concepto, BigDecimal cantidad, String divisa) {
		
		Importe importe = new Importe(cantidad, divisa);
		
		Cuenta cuenta = new Cuenta(idCuenta, null, null, null);
		
		Movimiento movimiento = new Movimiento(null, cuenta, concepto,  importe);
		
		new BancoDAOMySQL().addMovimiento(movimiento);
	}

	@Override
	public Iterable<Movimiento> listarMovimientos(Long id) {
		return new BancoDAOMySQL().getMovimientos(id);
	}

	@Override
	public void transferencia(Long idCuentaOrigen, Long idCuentaDestino, String conceptoOrigen, String conceptoDestino,
			BigDecimal cantidad, String divisa) {
		
		crearMovimientoEnCuenta(REINTEGRO, idCuentaOrigen, conceptoOrigen, cantidad, divisa);
		crearMovimientoEnCuenta(INGRESO, idCuentaDestino, conceptoDestino, cantidad, divisa);
	}

	@Override
	public void importarCSV(String rutaFicheroCSV) {
		try (FileInputStream fis = new FileInputStream(rutaFicheroCSV)) {
			try(BufferedReader br = new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8))) {
				
				String linea = null;
				
				if(br.readLine() == null) {
					throw new AccesoDatosException("No se ha encontrado ninguna línea en el fichero");
				}
				
				while( (linea = br.readLine()) != null) {
					String[] datos = linea.split(";");
					
					System.out.printf("%s, %s, %s, %s, %s", datos[0], datos[1], datos[2], datos[3], datos[4]);
					
					Long id = Long.parseLong(datos[1]);
					String concepto = datos[2];
					BigDecimal cantidad = new BigDecimal(datos[3].replace(',', '.'));
					String divisa = datos[4];
					
					System.out.printf(" -> %s, %s, %s, %s\n", id, concepto, cantidad, divisa);
					
					crearMovimientoEnCuenta(id, concepto, cantidad, divisa);
				}
			}
		} catch (FileNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el fichero", e);
		} catch (IOException e) {
			throw new AccesoDatosException("No se ha podido abrir el fichero", e);
		}
	}

}
