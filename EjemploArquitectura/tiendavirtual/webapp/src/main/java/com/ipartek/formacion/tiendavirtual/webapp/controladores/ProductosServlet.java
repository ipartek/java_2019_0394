package com.ipartek.formacion.tiendavirtual.webapp.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.tiendavirtual.modelos.Mensaje;
import com.ipartek.formacion.tiendavirtual.servicios.ProductoServicio;

@WebServlet("/productos")
public class ProductosServlet extends HttpServlet {
	private static final String PRODUCTOS_JSP = "/WEB-INF/vistas/productos.jsp";
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ProductoServicio servicio = (ProductoServicio) getServletContext().getAttribute("servicioProductos"); //ProductosServicioImpl.getInstancia();
			
			request.setAttribute("productos", servicio.getAll());
			
			//request.setAttribute("mensaje",	new Mensaje("info", "Se ha cargado la lista de productos"));
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("mensaje", new Mensaje("danger", "Ha habido un error al pedir los datos al servidor"));
		}
		
		request.getRequestDispatcher(PRODUCTOS_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
