package com.ipartek.formacion.tiendavirtual.webapp.controladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LeerFicheroConfiguracion")
public class LeerFicheroConfiguracion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rutaWebApp = request.getSession().getServletContext().getRealPath("/");
		String rutaConfiguracion = rutaWebApp + "WEB-INF\\configuracion.properties";

		//response.getWriter().append("Served at: ").append(rutaConfiguracion);

		try (InputStream inputStream = new FileInputStream(rutaConfiguracion)) {

			Properties prop = new Properties();
			// load a properties file
			prop.load(inputStream);

			// get value by key
			String motor = prop.getProperty("dao.motor");
			String url = prop.getProperty("dao.url");
			String user = prop.getProperty("dao.user");
			String password = prop.getProperty("dao.password");
			
			response.getWriter().append(motor).append(url).append(user).append(password);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
