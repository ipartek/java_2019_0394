<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form method="post">
	<div class="form-group row">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text" class="form-control ${producto.validezNombre}" id="nombre" name="nombre"
				placeholder="Introduce el nombre del producto"
				value="${producto.nombre}">
			<div class="invalid-feedback">${producto.errorNombre}</div>
		</div>
	</div>

	<div class="form-group row">
		<label for="descripcion" class="col-sm-2 col-form-label">Descripción</label>
		<div class="col-sm-10">
			<input type="text" class="form-control ${producto.validezDescripcion}" id="descripcion" name="descripcion"
				placeholder="Introduce la descripción del producto"
				value="${producto.descripcion}">
			<div class="invalid-feedback">${producto.errorDescripcion}</div>
		</div>
	</div>

	<div class="form-group row">
		<label for="precio" class="col-sm-2 col-form-label">Precio</label>
		<div class="col-sm-10">
			<input type="number" step=".01" class="form-control ${producto.validezPrecio}" id="precio" name="precio"
				placeholder="Introduce el precio del producto"
				value="${producto.precio}">
			<div class="invalid-feedback">${producto.errorPrecio}</div>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-primary">Añadir</button>
		</div>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>