<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de libros</title>

<base href="${pageContext.request.contextPath}/" />

<link rel="stylesheet" href="css/fontawesome-all.min.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />

<link rel="stylesheet" href="css/index.css" />

<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="listado">Librería</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="admin/listado">Admin</a></li>
			</ul>
		</div>
	</nav>
	<c:if test="${libro.error}">
		<div class="alert alert-danger alert-dismissible fade show"
			role="alert">
			Ha habido un error en el libro ${libro.errorId}
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>
	<main class="container">