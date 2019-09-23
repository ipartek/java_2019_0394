<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Tienda Virtual</title>

<base href="${pageContext.request.contextPath}/" />

<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/fontawesome-all.min.css" rel="stylesheet" />

<link href="css/tiendavirtual.css" rel="stylesheet" />

<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>
<body>
	<header>
		<h1>Tienda Virtual</h1>
	</header>
	<!-- Image and text -->
	<nav class="navbar navbar-dark bg-dark sticky-top">
		<a class="navbar-brand" href="#">Tienda Virtual
		</a>
	</nav>
	<c:if test="${mensaje != null}">
		<div
			class="alert alert-${mensaje.severidad} alert-dismissible fade show"
			role="alert">
			<fmt:formatDate pattern="dd-MM-yyyy hh:mm:ss"
				value="${mensaje.fecha}" />
			<strong>${mensaje.texto}</strong>
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>
	<main class="container"> <!-- Fin de cabecera -->