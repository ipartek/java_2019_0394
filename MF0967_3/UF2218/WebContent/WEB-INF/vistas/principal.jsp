<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ipartek.formacion.uf2218.modelos.Usuario,com.ipartek.formacion.uf2218.modelos.Producto"%>
<% Iterable<Producto> productos = (Iterable<Producto>)request.getAttribute("productos"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Principal</title>
</head>
<body>
	<% Usuario usuario = (Usuario)request.getSession().getAttribute("usuario"); %>
	<h1>Principal</h1>
	<h2>Bienvenido <%= usuario != null ? usuario.getUsuario() : "DESCONOCIDO" %></h2>
	<p>
		<a href="logout">Logout</a>
	</p>
	
	<table>
		<thead>
			<tr>
				<th>Id</th><th>Nombre</th><th>Precio</th>
			</tr>
		</thead>
		<tbody>
			<% for(Producto p: productos) { %>
				<tr>
					<td><%= p.getId() %></td>
					<td><%= p.getNombre() %></td>
					<td><%= p.getPrecio() %></td>
				</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>