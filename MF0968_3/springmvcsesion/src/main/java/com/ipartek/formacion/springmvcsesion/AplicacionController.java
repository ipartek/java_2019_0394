package com.ipartek.formacion.springmvcsesion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AplicacionController {
	@Autowired
	private TareasLista tareas;
	
	@GetMapping("/app")
	@ResponseBody
	public String tareas(@RequestParam(required = false) String texto) {
		if(texto != null) {
			tareas.addTarea(texto);
		}
		return tareas.toString();
	}
}
