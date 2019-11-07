package com.ipartek.formacion.ejemplocompleto.controladores;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ipartek.formacion.ejemplocompleto.entidades.Ponente;

@Controller
public class IndexController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/listado")
	public String listado(Model modelo) {
		ArrayList<Ponente> ponentes = new ArrayList<>();
		
		ponentes.add(new Ponente(1L, "Javier Lete", "Va a decir cosas mu chulas de muchas tecnologías..."));
		ponentes.add(new Ponente(2L, "Pepe Pérez", "Hablará sobre los nombres comunes utilizados en programación"));
		ponentes.add(new Ponente(3L, "Paco Pérez", "Hablará de los porteadores"));
		
		modelo.addAttribute("ponentes", ponentes);
		
		return "listado";
	}
}
