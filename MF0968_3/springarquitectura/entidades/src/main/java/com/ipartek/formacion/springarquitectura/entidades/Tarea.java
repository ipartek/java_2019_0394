package com.ipartek.formacion.springarquitectura.entidades;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tareas")
public @NoArgsConstructor @AllArgsConstructor @Data class Tarea {
	@Id
	@GeneratedValue
	private Long id;
	private String descripcion;
	private boolean terminada;
	private LocalDate fecha;
	@Column(name = "fecha_final")
	private LocalDate fechaFinal;
}
