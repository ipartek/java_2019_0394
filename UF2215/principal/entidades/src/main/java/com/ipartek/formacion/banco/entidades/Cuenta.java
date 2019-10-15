package com.ipartek.formacion.banco.entidades;

import java.util.TreeMap;

import lombok.Data;

public @Data class Cuenta {
	private final Long id;
	
	private final String codigoBanco;
	private final String codigoOficina;
	private final String codigoCuenta;
	
	private TreeMap<Long, Propietario> propietarios = new TreeMap<>();
	
	private TreeMap<Long, Movimiento> movimientos = new TreeMap<>();
	
	public String getIban() {
		return String.format("%s-%s-%s", codigoBanco, codigoOficina, codigoCuenta);
	}
	
	public String toString() {
		return getIban();
	}
}
