package com.ipartek.formacion.springmvcsesion;

import java.util.ArrayList;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("textos")
public class Prueba2Controller {
	private Logger log = Logger.getLogger(Prueba2Controller.class.getName());
	
	@ModelAttribute("textos")
	public ArrayList<String> textos() {
		return new ArrayList<String>();
	}
	
	@ResponseBody
	@GetMapping("/prueba2session")
	public String prueba2Session(@ModelAttribute("textos") ArrayList<String> textos) {
		textos.add("En prueba2");
		log.info(textos);
		return textos.toString();
	}
}
