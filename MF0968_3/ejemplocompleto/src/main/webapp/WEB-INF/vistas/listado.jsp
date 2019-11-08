<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/header.jsp"%>
<div class="container">
	<%-- <p>${ponentes}</p> --%>
	<div class="card-group">
		<c:forEach items="${ponentes}" var="ponente">
			<div class="card">
				<img class="card-img-top"
					src="http://lorempixel.com/500/500/people/${ponente.id}/Foto de ponente"
					alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">${ponente.nombre}</h5>
					<p class="card-text">${ponente.experiencia}</p>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<%@ include file="/WEB-INF/vistas/includes/footer.jsp"%>
