package com.ipartek.formacion.springmvcsesion;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("textos")
public class PruebaController {
	private Logger log = Logger.getLogger(PruebaController.class);

	@ModelAttribute("textos")
	public ArrayList<String> textos() {
		ArrayList<String> al = new ArrayList<>();
		al.add("Uno");
		al.add("Dos");
		al.add("Tres");
		return al;
	}
	
	@GetMapping("/pruebarequest")
	public String pruebaRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		log.info(request.getRequestURI());
		response.getWriter().write(request.getRequestURI());
		return null;
	}
	
	@GetMapping("/pruebasession")
	public String pruebaSession(@ModelAttribute("textos") ArrayList<String> textos) {
		textos.add("Nuevo");
		log.info(textos);
		log.info(textos.size());
		return null;
	}
}
