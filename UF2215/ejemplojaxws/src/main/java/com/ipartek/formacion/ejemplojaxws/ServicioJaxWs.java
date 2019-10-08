package com.ipartek.formacion.ejemplojaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ServicioJaxWs {
	@WebMethod
	public String saludar(String nombre) {
		return "Hola " + nombre;
	}

}
