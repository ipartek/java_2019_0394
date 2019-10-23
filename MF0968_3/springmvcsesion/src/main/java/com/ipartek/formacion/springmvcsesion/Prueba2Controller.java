package com.ipartek.formacion.springmvcsesion;

import java.util.ArrayList;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("textos")
public class Prueba2Controller {
	private Logger log = Logger.getLogger(Prueba2Controller.class.getName());
	
	@GetMapping("/prueba2session")
	public String prueba2Session(@ModelAttribute("textos") ArrayList<String> textos) {
		log.info(textos);
		return null;
	}
}
