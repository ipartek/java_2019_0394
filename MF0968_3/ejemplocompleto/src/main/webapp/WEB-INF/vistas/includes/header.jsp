<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
	<header>
		<!-- Static navbar -->
		<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
			<a class="navbar-brand" href="#">Conferencia</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link" href="listado">Listado
							de ponentes </a></li>
					<li class="nav-item"><a id="refrescarlistado" class="nav-link"
						href="#">REFRESCAR Listado de ponentes </a></li>
					<li class="nav-item"><a id="refrescarlistado" class="nav-link"
						href="formulario">Formulario</a></li>
				</ul>
			</div>
			<c:if test="${pageContext.request.remoteUser != null}">
				<form method="post" action="logout" class="form-inline my-2 my-lg-0">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<button class="btn btn-outline-danger my-2 my-sm-0" type="submit">
						Logout ${pageContext.request.remoteUser}
					</button>
				</form>
			</c:if>
			<c:if test="${pageContext.request.remoteUser == null}">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
				</ul>
			</c:if>
		</nav>
		<c:if test="${alerta != null}">
			<div class="alert alert-${alerta.nivel} alert-dismissible fade show"
				role="alert">
				${alerta.texto}
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<c:if test="${param.error != null}">
			<div class="alert alert-warning alert-dismissible fade show"
				role="alert">
				Credenciales inválidas
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<c:if test="${param.logout != null}">
			<div class="alert alert-success alert-dismissible fade show"
				role="alert">
				Has salido de sesión correctamente
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
	</header>