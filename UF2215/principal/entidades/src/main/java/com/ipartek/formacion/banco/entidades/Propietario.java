package com.ipartek.formacion.banco.entidades;

import java.util.TreeMap;

import lombok.Data;

public @Data class Propietario {
	private final Long id;
	
	private final String dni;
	private final String nombre, apellidos;
	
	private TreeMap<Long, Cuenta> cuentas = new TreeMap<>();
}
