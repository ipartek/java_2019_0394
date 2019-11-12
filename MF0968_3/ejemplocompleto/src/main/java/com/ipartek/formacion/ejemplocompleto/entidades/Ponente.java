package com.ipartek.formacion.ejemplocompleto.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ponentes")
public class Ponente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //Id; // Al poner el Id con I mayúscula, se ve en el Spring Data Rest API
	
	@NotNull
	@Size(min=2, max=30)
	private String nombre;
	@Size(max=255)
	private String experiencia;
}
