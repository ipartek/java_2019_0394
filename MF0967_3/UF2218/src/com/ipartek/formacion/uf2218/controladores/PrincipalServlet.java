package com.ipartek.formacion.uf2218.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2218.modelos.Producto;
import com.ipartek.formacion.uf2218.negocio.LogicaNegocio;

@WebServlet("/principal")
public class PrincipalServlet extends HttpServlet {
	private static final String VISTAS_PRINCIPAL_JSP = "/WEB-INF/vistas/principal.jsp";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Iterable<Producto> productos = LogicaNegocio.obtenerProductos();
		request.setAttribute("productos", productos);
		request.getRequestDispatcher(VISTAS_PRINCIPAL_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
