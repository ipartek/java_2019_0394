package com.ipartek.formacion.lombok;

import java.util.Date;

import lombok.Data;

public @Data class Persona {
	private Long id;
	private String nombre, apellidos, direccion;
	private Date fechaNacimiento;
	
	public String getNombre() {
		return nombre.toUpperCase();
	}
}
