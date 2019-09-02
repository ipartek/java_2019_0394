package com.ipartek.formacion.mf0967_3.controladores;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0967_3.modelo.Libro;
import com.ipartek.formacion.mf0967_3.servicios.LibrosServicio;
import com.ipartek.formacion.mf0967_3.servicios.LibrosServicioImpl;

@WebServlet("/admin/libroprocesar")
public class LibroProcesarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		
		String op = request.getParameter("op");
		
		if(op == null) {
			request.getRequestDispatcher("/admin/listado").forward(request, response);
			return;
		}
		
		LibrosServicio librosServicio = LibrosServicioImpl.getInstance();
		
		String id;
		Libro libro;
		
		switch(op) {
		case "borrar":
			id = request.getParameter("id");
			librosServicio.deleteLibro(Long.parseLong(id));
			break;
		case "modificar":
			libro = crearLibro(request);
			librosServicio.updateLibro(libro);
			break;
		case "alta":
			libro = crearLibro(request);
			librosServicio.insertLibro(libro);
			break;
		default:
			request.getRequestDispatcher("/admin/listado").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/admin/listado").forward(request, response);
	}

	private Libro crearLibro(HttpServletRequest request) {
		String id = request.getParameter("id");
		String imagen = request.getParameter("imagen");
		String descripcion = request.getParameter("descripcion");
		String autor = request.getParameter("autor");
		String precio = request.getParameter("precio");
		String descuento = request.getParameter("descuento");
		
		if(id == "") {
			id = "0";
		}
		
		Libro libro = new Libro(
				Long.parseLong(id),
				imagen,
				descripcion,
				autor,
				new BigDecimal(precio),
				new BigDecimal(descuento).divide(new BigDecimal(100)));
		return libro;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
