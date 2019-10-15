package com.ipartek.formacion.banco.webapp.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.banco.servicios.ServiciosBancarios;
import com.ipartek.formacion.banco.servicios.ServiciosBancariosImpl;


@WebServlet("/movimientos")
public class ListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		ServiciosBancarios servicios = new ServiciosBancariosImpl();
		
		request.setAttribute("movimientos", servicios.listarMovimientos(Long.parseLong(id)));
		
		request.getRequestDispatcher("/WEB-INF/vistas/movimientos.jsp").forward(request, response);
		
//		response.setContentType("text/plain");
//		PrintWriter pw = response.getWriter();
//		
//		ServiciosBancarios servicios = new ServiciosBancariosImpl();
//		
//		for(Movimiento m: servicios.listarMovimientos(1L)	){
//			pw.println(m);
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
