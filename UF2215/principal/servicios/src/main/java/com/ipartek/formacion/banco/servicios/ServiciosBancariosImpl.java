package com.ipartek.formacion.banco.servicios;

import java.math.BigDecimal;
import java.util.TreeMap;

import com.ipartek.formacion.banco.entidades.Cuenta;
import com.ipartek.formacion.banco.entidades.Importe;
import com.ipartek.formacion.banco.entidades.Movimiento;
import com.ipartek.formacion.banco.entidades.Propietario;

public class ServiciosBancariosImpl implements ServiciosBancarios {

	private static final boolean REINTEGRO = false;
	private static final boolean INGRESO = true;
	private static TreeMap<Long, Cuenta> cuentas = new TreeMap<>();
	private static TreeMap<Long, Movimiento> movimientos = new TreeMap<>();

	static {
		Propietario p1 = new Propietario(1L, "12345678Z", "Javier", "Lete");
		Propietario p2 = new Propietario(2L, "87654321A", "Pepe", "Pérez");

		Importe i1 = new Importe(new BigDecimal("123.45"), "EUR");
		Importe i2 = new Importe(new BigDecimal("543.21"), "EUR");

		Cuenta c1 = new Cuenta(1L, "1234", "5678", "12345678");
		Cuenta c2 = new Cuenta(2L, "4321", "8765", "87654321");

		c1.getPropietarios().put(1L, p1);
		c2.getPropietarios().put(2L, p2);

		Movimiento m1 = new Movimiento(1L, c1, "Ingreso inicial", i1);
		Movimiento m2 = new Movimiento(2L, c2, "Ingreso inicial", i2);

		c1.getMovimientos().put(m1.getId(), m1);
		c2.getMovimientos().put(m2.getId(), m2);

		movimientos.put(m1.getId(), m1);
		movimientos.put(m2.getId(), m2);
		
		cuentas.put(1L, c1);
		cuentas.put(2L, c2);
	}

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
		
		if(!cuentas.containsKey(idCuenta)) {
			throw new ServiciosBancariosException("No existe la cuenta " + idCuenta);
		}
		
		Cuenta cuenta = cuentas.get(idCuenta);
		
		Long id = movimientos.lastKey() + 1;
		
		Importe i = new Importe(ingreso ? cantidad : cantidad.multiply(new BigDecimal(-1)), divisa);
		
		Movimiento m = new Movimiento(id, cuenta, concepto,  i);
		
		cuenta.getMovimientos().put(m.getId(), m);
	}

	@Override
	public Iterable<Movimiento> listarMovimientos(Long id) {
		return cuentas.get(id).getMovimientos().values();
	}

	@Override
	public void transferencia(Long idCuentaOrigen, Long idCuentaDestino, String conceptoOrigen, String conceptoDestino,
			BigDecimal cantidad, String divisa) {
		
		crearMovimientoEnCuenta(REINTEGRO, idCuentaOrigen, conceptoOrigen, cantidad, divisa);
		crearMovimientoEnCuenta(INGRESO, idCuentaDestino, conceptoDestino, cantidad, divisa);
	}

}
