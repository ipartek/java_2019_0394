package com.ipartek.formacion.ejemplorest;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class RestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static TreeMap<Long, Alumno> alumnos = new TreeMap<>();

	static {
		alumnos.put(1L, new Alumno(1L, "Javier", "Lete"));
		alumnos.put(2L, new Alumno(2L, "Pepe", "Pérez"));

	}

	private Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		Long id = leerId(request);

		if (id == null) {
			response.getWriter().write(gson.toJson(alumnos.values().toArray()));
		} else if (id == -1) {
			noEncontrado(response);
		} else {
			Alumno alumno = alumnos.get(id);

			if (alumno == null) {
				noEncontrado(response);
			} else {
				response.getWriter().write(gson.toJson(alumno));
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		String body = leerBody(request);

		Alumno alumno = gson.fromJson(body, Alumno.class);

		alumno.setId(alumnos.lastKey() + 1);

		alumnos.put(alumno.getId(), alumno);

		response.setStatus(HttpServletResponse.SC_CREATED);

		response.getWriter().write(gson.toJson(alumno));
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		Long id = leerId(request);

		if (id == null || id == -1) {
			noEncontrado(response);
		} else {
			Alumno alumno = alumnos.get(id);

			if (alumno == null) {
				noEncontrado(response);
			} else {
				String body = leerBody(request);

				alumno = gson.fromJson(body, Alumno.class);

				alumnos.put(id, alumno);

				response.getWriter().write(gson.toJson(alumno));
			}
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String path = request.getPathInfo();

		response.setContentType("application/json");

		if (path == null || path.equals("/")) {
			noEncontrado(response);
		} else {
			Long id = Long.parseLong(path.substring(1));

			Alumno alumno = alumnos.get(id);

			if (alumno == null) {
				noEncontrado(response);
			} else {
				alumnos.remove(id);
				response.getWriter().write("{ }");
			}
		}

	}

	private String leerBody(HttpServletRequest request) throws IOException {
		BufferedReader br = request.getReader();
		StringBuffer sb = new StringBuffer();
		String linea;

		while ((linea = br.readLine()) != null) {
			sb.append(linea);
		}

		return sb.toString();
	}

	private Long leerId(HttpServletRequest request) {
		String path = request.getPathInfo();

		if (path == null || path.equals("/")) {
			return null;
		}

		try {
			return Long.parseLong(path.substring(1));
		} catch (NumberFormatException e) {
			return -1L;
		}

	}

	private void noEncontrado(HttpServletResponse response) throws IOException {
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		response.getWriter().println("{ }");
	}

}
