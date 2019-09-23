package com.ipartek.formacion.tiendavirtual.modelos;

import java.util.Date;

public class Mensaje {
	private Long id;
	private Date fecha;
	private String severidad, texto;
	
	public Mensaje(String severidad, String texto) {
		this(null, new Date(), severidad, texto);
	}
	
	public Mensaje(Long id, Date fecha, String severidad, String texto) {
		setId(id);
		setFecha(fecha);
		setSeveridad(severidad);
		setTexto(texto);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getSeveridad() {
		return severidad;
	}
	public void setSeveridad(String severidad) {
		this.severidad = severidad;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		result = prime * result + ((severidad == null) ? 0 : severidad.hashCode());
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
		Mensaje other = (Mensaje) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		if (severidad == null) {
			if (other.severidad != null)
				return false;
		} else if (!severidad.equals(other.severidad))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", fecha=" + fecha + ", severidad=" + severidad + ", texto=" + texto + "]";
	}
	
	
}
