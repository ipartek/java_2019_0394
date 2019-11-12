<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/header.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<form:form method="post" modelAttribute="ponente">
		<div class="form-group row">
			<form:label path="nombre" class="col-sm-2 col-form-label">Nombre</form:label>
			<div class="col-sm-10">
				<form:input class="form-control" id="nombre" path="nombre"
					placeholder="Nombre"/>
					<form:errors path="nombre" cssClass="error" element="div" />
			</div>
			
		</div>
		<div class="form-group row">
			<form:label path="experiencia" class="col-sm-2 col-form-label">Experiencia</form:label>
			<div class="col-sm-10">
				<form:input class="form-control" id="experiencia" path="experiencia"
					placeholder="Experiencia"/>
				<form:errors path="experiencia" cssClass="error" element="div" />
			</div>
			
		</div>
		
		<div class="form-group row">
			<label class="col-sm-2 col-form-label"></label>
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary">Aceptar</button>
			</div>
		</div>
	</form:form>
</div>

<!-- <script src="js/formulario.js"></script> -->
<%@ include file="/WEB-INF/vistas/includes/footer.jsp"%>
