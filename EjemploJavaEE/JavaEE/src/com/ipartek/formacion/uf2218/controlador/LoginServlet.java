package com.ipartek.formacion.uf2218.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2218.modelo.ModeloException;
import com.ipartek.formacion.uf2218.modelo.Usuario;
import com.ipartek.formacion.uf2218.negocio.LogicaNegocio;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final String VISTAS_LOGIN_JSP = "/WEB-INF/vistas/login.jsp";
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recoger información de la petición
		String nick = request.getParameter("nick");
		String password = request.getParameter("password");
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		
		// Empaquetar en objetos del modelo
		if(usuario == null) {
			try {
				usuario = new Usuario(nick, password);
			} catch (ModeloException e) {
				request.getRequestDispatcher(VISTAS_LOGIN_JSP).forward(request, response);
				return;
			}
		}
		
		if(!usuario.isValido()) {
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher(VISTAS_LOGIN_JSP).forward(request, response);
			return;
		}
		
		// Ejecutar lógica de negocio
		if(LogicaNegocio.isAutenticado(usuario)) {
			// Redireccionar a un controlador
			request.getSession().setAttribute("usuario", usuario);
			request.getRequestDispatcher("principal").forward(request, response);
		} else {
			// Redireccionar a una vista
			usuario.setErrorUsuario("Las credenciales no son correctas");
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher(VISTAS_LOGIN_JSP).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
