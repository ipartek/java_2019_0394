package com.ipartek.formacion.tiendavirtual.webapp.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.ipartek.formacion.tiendavirtual.servicios.ProductosServicioImpl;

@WebListener
public class InicioAplicacionListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
    	String rutaWebApp = sce.getServletContext().getRealPath("/");
		String rutaConfiguracion = rutaWebApp + "WEB-INF\\configuracion.properties";
    	sce.getServletContext().setAttribute("servicioProductos", ProductosServicioImpl.crearInstancia(rutaConfiguracion));
    }

    public void contextDestroyed(ServletContextEvent sce)  {
    	// NO sabemos si se va a ejecutar a ciencia cierta
    }
}
