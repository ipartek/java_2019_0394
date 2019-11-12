<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/header.jsp"%>

<div class="container">
	<c:if test="${param.error}">
		<div>Invalid username and password.</div>
	</c:if>
	<c:if test="${param.logout}">
		<div>You have been logged out.</div>
	</c:if>
	<form method="post">
		<div class="form-group row">
			<label for="usuario" class="col-sm-2 col-form-label">Usuario</label>
			<div class="col-sm-10">
				<input class="form-control" id="usuario" name="username"
					placeholder="Usuario" />
			</div>

		</div>
		<div class="form-group row">
			<label for="password" class="col-sm-2 col-form-label">Contraseña</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="password"
					name="password" placeholder="Contraseña" />
			</div>

		</div>

		<div class="form-group row">
			<label class="col-sm-2 col-form-label"></label>
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary">Aceptar</button>
			</div>
		</div>
	</form>
</div>

<%@ include file="/WEB-INF/vistas/includes/footer.jsp"%>
