package com.ipartek.formacion.uf2218.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2218.modelos.Usuario;
import com.ipartek.formacion.uf2218.negocio.LogicaNegocio;

@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		
//		String usuario = request.getParameter("usuario");
//		String password = request.getParameter("password");
		
		// 1. Recoger información de la petición
		// 2. Crear objetos del modelo en base a la petición
		Usuario usuario = new Usuario(
				request.getParameter("usuario"), 
				request.getParameter("password")
		); 
		
//		if(usuario == null || password == null) {
//			//nombre = "DESCONOCIDO";
//			throw new RuntimeException("No se ha recibido ni nombre ni password");
//		}
		
		//if("javier".equals(usuario) && "lete".equals(password)) {
		
		// 3. Llamar a la lógica de negocio con los objetos correspondientes
		if(LogicaNegocio.autenticar(usuario)) {
			// 4. Redireccionar a la siguiente vista
			response.sendRedirect("principal.html");
		} else {
			// 4. Redireccionar a la siguiente vista
			response.sendRedirect("error.html");
		}
		
//		PrintWriter out = response.getWriter();
//		
//		out.println("Hola " + nombre);
//		out.println("Password " + password);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
