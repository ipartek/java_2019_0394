package com.ipartek.formacion.springresumen.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipartek.formacion.springresumen.UsuarioRepository;
import com.ipartek.formacion.springresumen.modelo.Usuario;

@Controller
public class IndexController {
	// @RequestMapping("/")
	@GetMapping("/")
	public String index(@RequestParam(required = false, defaultValue = "alumnos") String persona, Model modelo,
			@ModelAttribute Usuario usuario) {
		modelo.addAttribute("persona", persona);
		return "index";
	}

	@Autowired
	private UsuarioRepository repositorio;

	@PostMapping
	public String procesarFormulario(@Valid @ModelAttribute Usuario usuario, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "index";
		}

		repositorio.save(usuario);

		return "redirect:/listado";
	}

	@GetMapping("/listado")
	public String listado(Model modelo) {
		modelo.addAttribute("usuarios", repositorio.findAll());

		return "listado";
	}

	@Autowired
	private JdbcTemplate jdbc;
	
	@GetMapping("/listadojdbc")
	public String listadoJdbc(Model modelo) {
		List<Usuario> usuarios = jdbc.query(
				"SELECT id, nombre, email FROM usuarios", new Object[] {},
				(rs, rowNum) -> 
					new Usuario(rs.getLong("id"), rs.getString("nombre"), rs.getString("email")));
		modelo.addAttribute("usuarios", usuarios);
		
		return "listado";
	}

	@GetMapping("/altajdbc")
	public String altaJdbc() {
		Usuario usuario = new Usuario(null, "Nuevo", "nuevo@email.net");
		
		jdbc.update("INSERT INTO usuarios (nombre, email) VALUES (?, ?)",
				new Object[] { usuario.getNombre(), usuario.getEmail() });
		
		return "redirect:/listadojdbc";
	}
	
//	@PostMapping
//	@ResponseBody
//	public String procesarFormulario(
//			@ModelAttribute Usuario usuario,
//			HttpServletResponse response) {
//		response.setHeader("Content-Disposition", "attachment; filename=usuario.csv");
//		response.setContentType("application/vnd.ms-excel");
//		
//		return usuario.getNombre() + ";" + usuario.getEmail(); 
//	}

	@GetMapping("/usuario/{id}")
	@ResponseBody
	public String mostrarIdEnUrl(@PathVariable Long id) {
		return id.toString();
	}

	@PostMapping("/usuarios")
	@ResponseBody
	public String mostrarUsuarioPost(@RequestBody Usuario usuario) {
		return usuario.toString();
	}
}
