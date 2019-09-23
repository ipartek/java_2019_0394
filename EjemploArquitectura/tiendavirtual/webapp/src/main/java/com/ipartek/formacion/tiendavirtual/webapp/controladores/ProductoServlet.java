package com.ipartek.formacion.tiendavirtual.webapp.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.tiendavirtual.modelos.Mensaje;
import com.ipartek.formacion.tiendavirtual.modelos.Producto;
import com.ipartek.formacion.tiendavirtual.servicios.ProductoServicio;

@WebServlet("/producto")
public class ProductoServlet extends HttpServlet {
	private static final String PRODUCTO_JSP = "/WEB-INF/vistas/producto.jsp";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(PRODUCTO_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			String precio = request.getParameter("precio");

			Producto producto = new Producto(nombre, descripcion, precio);

			if (producto.isError()) {
				request.setAttribute("producto", producto);
			} else {
				producto = ((ProductoServicio) getServletContext().getAttribute("servicioProductos")).insert(producto);
				
				request.setAttribute("mensaje", new Mensaje("success", "Registro insertado correctamente con el id " + producto.getId()));
				request.getRequestDispatcher("/productos").forward(request, response);
				
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("mensaje", new Mensaje("danger", "Error al dar de alta el usuario"));
		}

		request.getRequestDispatcher(PRODUCTO_JSP).forward(request, response);
	}

}
