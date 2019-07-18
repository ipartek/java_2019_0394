package com.ipartek.formacion.uf2218.negocio;

import com.ipartek.formacion.uf2218.modelos.Usuario;

public class LogicaNegocio {

	public static boolean autenticar(Usuario usuario) {
		return "javier".equals(usuario.getUsuario()) && 
				"lete".equals(usuario.getPassword());
	}
}
