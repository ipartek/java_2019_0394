package com.ipartek.formacion.uf2218.negocio;

import com.ipartek.formacion.uf2218.modelo.Usuario;

public class LogicaNegocio {
	public static boolean isAutenticado(Usuario usuario) {
		return "javier".equals(usuario.getNick()) &&
				"lete".equals(usuario.getPassword());
	}
}
