package com.ipartek.formacion.banco.entidades;

import lombok.Data;

public @Data class Movimiento {
	private final Long id;
	
	private final Cuenta cuenta;
	private final String concepto;
	private final Importe importe;
	
	public String toString() {
		return String.format("%s | %s | %s", cuenta, concepto, importe);
	}
}
