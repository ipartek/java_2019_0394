<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/header.jsp"%>
<div class="container">

	<form method="post">
		<div class="form-group row">
			<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
			<div class="col-sm-10">
				<input class="form-control" id="nombre" name="nombre"
					placeholder="Nombre">
			</div>
		</div>
		<div class="form-group row">
			<label for="experiencia" class="col-sm-2 col-form-label">Experiencia</label>
			<div class="col-sm-10">
				<input class="form-control" id="experiencia" name="experiencia"
					placeholder="Experiencia">
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

<script src="js/formulario.js"></script>
<%@ include file="/WEB-INF/vistas/includes/footer.jsp"%>
