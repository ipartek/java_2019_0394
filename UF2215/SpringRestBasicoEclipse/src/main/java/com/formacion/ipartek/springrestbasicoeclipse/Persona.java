package com.formacion.ipartek.springrestbasicoeclipse;

import lombok.AllArgsConstructor;
import lombok.Data;

public @AllArgsConstructor @Data class Persona {
	private Long id;
	private String nombre, apellidos;
}
