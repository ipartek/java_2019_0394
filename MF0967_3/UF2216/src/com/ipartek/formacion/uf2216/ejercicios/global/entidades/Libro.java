package com.ipartek.formacion.uf2216.ejercicios.global.entidades;

public class Libro {
	//TODO: ISBN, Editorial, Autor, Descripción, Género, Edición, IsBorrado, Fecha de impresión
	private long id;
	private String titulo;
	
	public Libro(long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + "]";
	}
}
