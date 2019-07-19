<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ipartek.formacion.uf2218.modelos.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Principal</title>
</head>
<body>
	<% Usuario usuario = (Usuario)request.getSession().getAttribute("usuario"); %>
	<h1>Principal</h1>
	<h2>Bienvenido <%= usuario.getUsuario() %></h2>
	<p>
		<a href="logout">Logout</a>
	</p>
</body>
</html>