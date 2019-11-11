package com.ipartek.formacion.ejemplocompleto.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ipartek.formacion.ejemplocompleto.entidades.Ponente;
import com.ipartek.formacion.ejemplocompleto.modelo.Alerta;
import com.ipartek.formacion.ejemplocompleto.servicios.PonenteService;

@Controller
public class PonenteController {
	@Autowired
	private PonenteService ponenteService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/listado")
	public String listado(Model modelo) {
		Iterable<Ponente> ponentes = ponenteService.getPonentes();
		
		modelo.addAttribute("ponentes", ponentes);
		
		return "listado";
	}
	
	@GetMapping("/formulario")
	public String formulario() {
		return "formulario";
	}
	
	@PostMapping("/formulario")
	public String formulario(Ponente ponente, RedirectAttributes attrs) {
		ponenteService.addPonente(ponente);
		
		Alerta alerta = new Alerta();
		
		alerta.setTexto("Insertado correctamente");
		alerta.setNivel("success");
		
		attrs.addFlashAttribute(alerta);
		
		return "redirect:/listado";
	}
}
