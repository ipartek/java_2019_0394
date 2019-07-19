<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ipartek.formacion.uf2218.modelos.Usuario,com.ipartek.formacion.uf2218.modelos.Producto"%>
<%-- <% Iterable<Producto> productos = (Iterable<Producto>)request.getAttribute("productos"); %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Principal</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<jsp:useBean id="productos" scope="request" type="Iterable<Producto>" />
	<jsp:useBean id="usuario" scope="session" class="com.ipartek.formacion.uf2218.modelos.Usuario" />
	
	<%-- <% Usuario usuario = (Usuario)request.getSession().getAttribute("usuario"); %>--%>
	<h1>Principal</h1>
	<h2>Bienvenido <jsp:getProperty property="usuario" name="usuario"/> <%-- <%= usuario != null ? usuario.getUsuario() : "DESCONOCIDO" %> --%></h2>
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
			<c:forEach items="${productos}" var="p">
				<tr>
					<td>${p.id}</td>
					<td>${p.nombre}</td>
					<td>${p.precio}</td>
				</tr>
			</c:forEach>
<%-- 			<% for(Producto p: productos) { %>
				<tr>
					<td><%= p.getId() %></td>
					<td><%= p.getNombre() %></td>
					<td><%= p.getPrecio() %></td>
				</tr>
			<% } %>
 --%>		</tbody>
	</table>
</body>
</html>