package com.ipartek.formacion.tiendavirtual.webapp.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.tiendavirtual.servicios.ProductoServicio;
import com.ipartek.formacion.tiendavirtual.servicios.ProductosServicioImpl;

@WebServlet("/productos")
public class ListadoProductosServlet extends HttpServlet {
	private static final String PRODUCTOS_JSP = "/WEB-INF/vistas/productos.jsp";
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoServicio servicio = new ProductosServicioImpl();
		
		request.setAttribute("productos", servicio.getAll());
		
		request.getRequestDispatcher(PRODUCTOS_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
