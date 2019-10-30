package com.ipartek.formacion.springresumen.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.springresumen.UsuarioRepository;
import com.ipartek.formacion.springresumen.modelo.Usuario;

@RestController
public class ApiController {
	@Autowired
	private UsuarioRepository repositorio;
	
	@GetMapping("/api/usuarios")
	public Iterable<Usuario> getAll() {
		return repositorio.findAll();
	}
	
	@PostMapping("/api/usuarios")
	@ResponseBody
	public Usuario post(@RequestBody Usuario usuario) {
		repositorio.save(usuario);
		return usuario;
	}
}
