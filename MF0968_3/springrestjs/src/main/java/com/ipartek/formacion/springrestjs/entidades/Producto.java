package com.ipartek.formacion.springrestjs.entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name = "productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull //Validación y base de datos
	@Size(max = 50) //Validación
	//@Column(columnDefinition = "VARCHAR(50)") //Definición de campo de base de datos
	private String nombre;
	
	@Column(columnDefinition = "TEXT")
	private String descripcion;
	
	@Min(value = 0)
	private BigDecimal precio;
}
