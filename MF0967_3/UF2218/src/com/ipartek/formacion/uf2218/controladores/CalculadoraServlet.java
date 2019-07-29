package com.ipartek.formacion.uf2218.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculadora/calcular")
public class CalculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long op1, op2, res;
		char op;

		op1 = Long.parseLong(request.getParameter("op1"));
		op2 = Long.parseLong(request.getParameter("op2"));
		op = request.getParameter("op").charAt(0);

		switch (op) {
		case '+':
			res = op1 + op2;
			break;
		case '-':
			res = op1 - op2;
			break;
		case '*':
			res = op1 * op2;
			break;
		case '/':
			res = op1 / op2;
			break;
		default:
			throw new RuntimeException("La opción " + op + " no existe");
		}
		
		request.setAttribute("op1", op1);
		request.setAttribute("op2", op2);
		request.setAttribute("op", op);
		request.setAttribute("res", res);
		
		request.getRequestDispatcher("/calculadora/index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
