package com.ipartek.formacion.springarquitectura.webapp.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ipartek.formacion.springarquitectura.servicio.TareaService;

@Controller
public class TareasController {
	@Inject
	private TareaService servicio;
	
	@GetMapping("/tareas")
	public String getAll(Model model) {
		model.addAttribute("tareas", servicio.getAll());
		return "tareas";
	}
}
