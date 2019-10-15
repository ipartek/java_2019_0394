package com.ipartek.formacion.banco.entidades;

import java.math.BigDecimal;

import lombok.Value;

public @Value class Importe {
	private final BigDecimal cantidad;
	private final String divisa;
}
