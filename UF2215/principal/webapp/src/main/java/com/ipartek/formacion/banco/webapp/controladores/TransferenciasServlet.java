package com.ipartek.formacion.banco.webapp.controladores;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.banco.servicios.ServiciosBancarios;
import com.ipartek.formacion.banco.servicios.ServiciosBancariosException;
import com.ipartek.formacion.banco.servicios.ServiciosBancariosImpl;
import com.ipartek.formacion.banco.webapp.modelos.TransferenciaForm;

@WebServlet("/transferencias")
public class TransferenciasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/transferencias.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TransferenciaForm form = new TransferenciaForm();
		try {
			form.setCuentaOrigen(request.getParameter("cuentaOrigen"));
			form.setCuentaDestino(request.getParameter("cuentaDestino"));
			form.setConceptoOrigen(request.getParameter("conceptoOrigen"));
			form.setConceptoDestino(request.getParameter("conceptoDestino"));
			form.setImporte(request.getParameter("importe"));
			form.setDivisa(request.getParameter("divisa"));

			if (form.isCorrecto()) {
				ServiciosBancarios servicios = new ServiciosBancariosImpl();

				try {
					servicios.transferencia(Long.parseLong(form.getCuentaOrigen()), Long.parseLong(form.getCuentaDestino()),
							form.getConceptoOrigen(), form.getConceptoDestino(), new BigDecimal(form.getImporte()),
							form.getDivisa());
				} catch (ServiciosBancariosException e) {
					form.setCorrecto(false);
					form.setErrorGeneral(e.getMessage());
					e.printStackTrace();
					
					request.setAttribute("form", form);
					request.getRequestDispatcher("/WEB-INF/vistas/transferencias.jsp").forward(request, response);
				}
				response.sendRedirect("movimientos?id=" + form.getCuentaOrigen());
			} else {
				request.setAttribute("form", form);
				request.getRequestDispatcher("/WEB-INF/vistas/transferencias.jsp").forward(request, response);
			}
		} catch (Exception e) {
			form.setCorrecto(false);
			form.setErrorGeneral("Error no esperado");
			System.out.println(form);
			e.printStackTrace();
			
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/vistas/transferencias.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

}
