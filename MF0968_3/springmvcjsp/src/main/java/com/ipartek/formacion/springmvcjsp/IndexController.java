package com.ipartek.formacion.springmvcjsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("datos", new String[] { "Uno", "Dos", "Tres" });
		return "index";
	}

}
