package com.ipartek.formacion.ejemplocompleto.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/listado")
	public String listado() {
		return "listado";
	}
}
