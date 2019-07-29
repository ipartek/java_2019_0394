package com.ipartek.formacion.uf2218.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2218.modelos.Calculadora;

@WebServlet("/calculadora/calcular")
public class CalculadoraServlet extends HttpServlet {
	private static final String CALCULADORA_JSP = "/WEB-INF/vistas/calculadora.jsp";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op1, op2, op;

		op1 = request.getParameter("op1");
		op2 = request.getParameter("op2");
		op = request.getParameter("op");

		if(op == null || op2 == null || op1 == null) {
			request.getRequestDispatcher(CALCULADORA_JSP).forward(request, response);
			return;
		}
		
		Calculadora cal = new Calculadora(op1, op, op2);
		request.setAttribute("cal", cal);
		request.getRequestDispatcher(CALCULADORA_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
