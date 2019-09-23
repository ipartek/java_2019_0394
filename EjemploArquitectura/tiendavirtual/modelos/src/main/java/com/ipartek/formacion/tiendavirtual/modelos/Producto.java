package com.ipartek.formacion.tiendavirtual.modelos;

import java.math.BigDecimal;

public class Producto {
	private static final String IS_INVALID = "is-invalid";
	private static final String IS_VALID = "is-valid";
	private Long id;
	private String nombre, descripcion;
	private BigDecimal precio;

	private boolean error = false;
	private String validezNombre = "", validezDescripcion = "", validezPrecio = "";
	private String errorNombre = "", errorDescripcion = "", errorPrecio = "";

	public Producto(String nombre, String descripcion, String precio) {
		this(null, nombre, descripcion, precio);
	}

	public Producto(Long id, String nombre, String descripcion, String precio) {
		setId(id);
		setNombre(nombre);
		setDescripcion(descripcion);
		setPrecio(precio);
	}

	public Producto(Long id, String nombre, String descripcion, BigDecimal precio) {
		setId(id);
		setNombre(nombre);
		setDescripcion(descripcion);
		setPrecio(precio);
	}

	public Producto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null) {
			throw new ModeloException("No se admiten nombres nulos");
		}

		if (nombre.trim().length() == 0) {
			setErrorNombre("No se permiten nombres vacíos");
		}

		this.nombre = nombre;

		if (getErrorNombre().equals("")) {
			setValidezNombre(IS_VALID);
		}
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		setValidezDescripcion(IS_VALID);
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		if (precio == null) {
			throw new ModeloException("No se admite un precio nulo");
		}

		if (precio.compareTo(new BigDecimal(0)) < 0) {
			setErrorPrecio("El precio debe ser 0 o positivo");
		}

		this.precio = precio;

		if(getErrorPrecio().equals("")) {
			setValidezPrecio(IS_VALID);
		}
	}

	public void setPrecio(String precio) {
		if (precio == null) {
			throw new ModeloException("No se admite un precio nulo");
		}

		if (precio.trim().length() == 0) {
			setErrorPrecio("El precio se debe rellenar");
			return;
		}

		try {
			setPrecio(new BigDecimal(precio));
		} catch (NumberFormatException e) {
			setErrorPrecio("El precio debe ser un número con máximo de dos decimales");
		}
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getErrorNombre() {
		return errorNombre;
	}

	public void setErrorNombre(String errorNombre) {
		setError(true);
		setValidezNombre(IS_INVALID);
		this.errorNombre = errorNombre;
	}

	public String getErrorDescripcion() {
		return errorDescripcion;
	}

	public void setErrorDescripcion(String errorDescripcion) {
		setError(true);
		setValidezDescripcion(IS_INVALID);
		this.errorDescripcion = errorDescripcion;
	}

	public String getErrorPrecio() {
		return errorPrecio;
	}

	public void setErrorPrecio(String errorPrecio) {
		setError(true);
		setValidezPrecio(IS_INVALID);
		this.errorPrecio = errorPrecio;
	}

	public String getValidezNombre() {
		return validezNombre;
	}

	public void setValidezNombre(String validezNombre) {
		this.validezNombre = validezNombre;
	}

	public String getValidezDescripcion() {
		return validezDescripcion;
	}

	public void setValidezDescripcion(String validezDescripcion) {
		this.validezDescripcion = validezDescripcion;
	}

	public String getValidezPrecio() {
		return validezPrecio;
	}

	public void setValidezPrecio(String validezPrecio) {
		this.validezPrecio = validezPrecio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ "]";
	}

}
