package com.ipartek.formacion.ejemplocompleto.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ponente {
	private Long id;
	private String nombre, experiencia;
}
