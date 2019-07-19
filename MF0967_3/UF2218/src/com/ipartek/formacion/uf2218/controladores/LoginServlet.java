package com.ipartek.formacion.uf2218.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2218.modelos.ModeloException;
import com.ipartek.formacion.uf2218.modelos.Usuario;
import com.ipartek.formacion.uf2218.negocio.LogicaNegocio;

@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final String VISTAS_PRINCIPAL_JSP = "/WEB-INF/vistas/principal.jsp";
	private static final String VISTAS_LOGIN_JSP = "/WEB-INF/vistas/login.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		
		final RequestDispatcher requestDispatcherLogin = request.getRequestDispatcher(VISTAS_LOGIN_JSP);
		final RequestDispatcher requestDispatcherPrincipal = request.getRequestDispatcher(VISTAS_PRINCIPAL_JSP);
		
		// 1. Recoger información de la petición
		// 2. Crear objetos del modelo en base a la petición
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		
		if(usuario != null) {
			requestDispatcherPrincipal.forward(request, response);
			return;
		}
		
		try {
			usuario = new Usuario(
					request.getParameter("usuario"), 
					request.getParameter("password")
			);
		} catch (ModeloException e) {
			//response.sendRedirect("vistas/login.jsp");
			requestDispatcherLogin.forward(request, response);
			return;
		}
		
		// 3. Llamar a la lógica de negocio con los objetos correspondientes
		if(LogicaNegocio.autenticar(usuario)) {
			// 4. Redireccionar a la siguiente vista
			//response.sendRedirect("vistas/principal.html");
			request.getSession().setAttribute("usuario", usuario);
			//request.getRequestDispatcher("vistas/principal.jsp").forward(request, response);
			requestDispatcherPrincipal.forward(request, response);
		} else {
			// 4. Redireccionar a la siguiente vista
			//response.sendRedirect("vistas/login.jsp?usuario=" + request.getParameter("usuario"));
			usuario.setError("Login incorrecto");
			
			//Guarda un objeto usuario en la Request
			request.setAttribute("usuario", usuario);
			//Llama al método del destino
			requestDispatcherLogin.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private static final long serialVersionUID = 1L;
}
