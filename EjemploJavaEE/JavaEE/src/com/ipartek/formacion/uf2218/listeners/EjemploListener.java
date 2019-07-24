package com.ipartek.formacion.uf2218.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ipartek.formacion.uf2218.modelo.Usuario;

/**
 * Application Lifecycle Listener implementation class EjemploListener
 *
 */
@WebListener
public class EjemploListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("creador", new Usuario("javierlete", ""));
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().setAttribute("carrito", new Object());		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Se ha cerrado una sesión");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Se ha cerrado la aplicación");
	}
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("AÑADIDO: " + event.getName() + ": " + event.getValue());
	}

	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("ELIMINADO: " + event.getName());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("REEMPLAZADO: " + event.getName() + ": " + event.getValue());
	}

	

	
}
