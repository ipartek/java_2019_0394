package com.ipartek.formacion.banco.servicios;

import java.math.BigDecimal;

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
		
		Importe importe = new Importe(ingreso ? cantidad : cantidad.multiply(new BigDecimal(-1)), divisa);
		
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

}
