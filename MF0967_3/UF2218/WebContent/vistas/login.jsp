<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ipartek.formacion.uf2218.modelos.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo de formulario</title>
</head>
<body>
	<%-- 
	<% for(int i = 1; i <= 6; i++) { %>
		<h<%=i %>>Ejemplo JSP nivel <%=i %></h2>
	<% } %>
	--%>
	
	<% Usuario usuario = (Usuario)request.getAttribute("usuario"); %>
	
	<form action="login" method="post">
		<div>
			<label for="usuario">Usuario</label>
			<input id="usuario" name="usuario" value="<%=usuario != null ? usuario.getUsuario() : "" %><%--<%=request.getParameter("usuario") != null ? request.getParameter("usuario") : "" %>--%>" />
		</div>
		<div>
			<label for="password">Contraseña</label>
			<input type="password" id="password" name="password" />		
		</div>
		<div>
			<button>Login</button>
		</div>
		<div class="error">
			<%= usuario != null ? usuario.getError() : "" %>
			<%-- <%=request.getParameter("error") != null ? request.getParameter("error") : "" %> --%>
		</div>
	</form>
</body>
</html>