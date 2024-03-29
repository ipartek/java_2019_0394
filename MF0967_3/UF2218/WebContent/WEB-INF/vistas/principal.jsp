<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Principal</h2>

<c:if test="${usuario != null}">
	<h2>Bienvenido ${usuario.usuario}</h2>
	<p>
		<a href="logout">Logout</a>
	</p>
</c:if>

<c:choose>
	<c:when test="${usuario != null}">
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Precio</th>
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
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
		<p>
			No tienes permiso para ver los productos. Puedes hacer <a href="login">Login</a>
		</p>
	</c:otherwise>
</c:choose>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>