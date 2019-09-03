package com.ipartek.formacion.mf0967_3.controladores;

import java.io.IOException;

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
			irAListado(request, response);
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
			libro = crearLibro(request, response);
			if(libro.isError()) {
				irAMostrarLibro(request, response, libro);
				return;
			}
			librosServicio.updateLibro(libro);
			break;
		case "alta":
			libro = crearLibro(request, response);
			if(libro.isError()) {
				irAMostrarLibro(request, response, libro);
				return;
			}
			librosServicio.insertLibro(libro);
			break;
		default:
			irAListado(request, response);
			return;
		}
		
		irAListado(request, response);
	}

	private void irAMostrarLibro(HttpServletRequest request, HttpServletResponse response, Libro libro)
			throws ServletException, IOException {
		request.setAttribute("libro", libro);
		request.setAttribute("op", libro.getId() == 0 ? "alta" : "modificar");
		request.getRequestDispatcher("/WEB-INF/vistas/libro.jsp").forward(request, response);
	}

	private void irAListado(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//request.getRequestDispatcher("/admin/listado").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/admin/listado");
	}

	private Libro crearLibro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				id,
				imagen,
				descripcion,
				autor,
				precio,
				descuento);
		
		return libro;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
