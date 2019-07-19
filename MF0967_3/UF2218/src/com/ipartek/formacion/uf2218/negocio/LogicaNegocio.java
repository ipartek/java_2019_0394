package com.ipartek.formacion.uf2218.negocio;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.ipartek.formacion.uf2218.modelos.Producto;
import com.ipartek.formacion.uf2218.modelos.Usuario;

public class LogicaNegocio {

	public static boolean autenticar(Usuario usuario) {
		return "javier".equals(usuario.getUsuario()) && 
				"lete".equals(usuario.getPassword());
	}
	
	public static Iterable<Producto> obtenerProductos() {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		productos.add(new Producto(1L, "Monitor", new BigDecimal("123.12")));
		productos.add(new Producto(2L, "Ratón", new BigDecimal("12.12")));
		productos.add(new Producto(3L, "Teclado", new BigDecimal("23.12")));
		
		return productos;
	}
}
