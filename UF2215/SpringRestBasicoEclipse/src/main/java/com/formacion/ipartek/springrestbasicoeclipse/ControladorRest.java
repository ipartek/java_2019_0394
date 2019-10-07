package com.formacion.ipartek.springrestbasicoeclipse;

import java.util.TreeMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorRest {
	private static TreeMap<Long, Persona> personas = new TreeMap<>();

	static {
		personas.put(1L, new Persona(1L, "Javier", "Lete"));
		personas.put(2L, new Persona(2L, "Pepe", "Pérez"));
	}

	@RequestMapping(method = RequestMethod.GET, path = "/api/personas")
	public Iterable<Persona> getAll() {
		return personas.values();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/api/personas/{id}")
	public Persona getById(@PathVariable("id") Long id) {
		return personas.get(id);
	}
}
