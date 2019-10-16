package com.ipartek.formacion.banco.servicios;

import java.math.BigDecimal;

import com.ipartek.formacion.banco.entidades.Movimiento;

public interface ServiciosBancarios {
	void ingreso(Long idCuenta, String concepto, BigDecimal cantidad, String divisa);
	void reintegro(Long idCuenta, String concepto, BigDecimal cantidad, String divisa);
	Iterable<Movimiento> listarMovimientos(Long id);
	void transferencia(Long idCuentaOrigen, Long idCuentaDestino, String conceptoOrigen, String conceptoDestino, BigDecimal cantidad, String divisa);
	
	void importarCSV(String rutaFicheroCSV);
}
