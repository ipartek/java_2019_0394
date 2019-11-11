package com.ipartek.formacion.ejemplocompleto.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Alerta {
	private String texto;
	private String nivel;
}
