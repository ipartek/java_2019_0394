'use strict';

$(function() {
	$('form button').click(function(e) {
		e.preventDefault();
		
		var ponente = {
			nombre: $('#nombre').val(),
			experiencia: $('#experiencia').val()
		};
		
		$.ajax({
			url: 'http://localhost:8080/api/ponentes',
			method: 'POST',
			data: JSON.stringify(ponente),
			dataType: 'json',
			contentType: 'application/json'
		}).done(function (ponente) {
			var alerta = { nivel: 'success', texto: 'Inserción del registro correcta. ID:' + ponente.id}
			$('header').append(mostrarAlerta(alerta));
		}).fail(function () {
			var alerta = { nivel: 'danger', texto: 'No se ha podido insertar' };
			$('header').append(mostrarAlerta(alerta));
		});
		
	});
});

function mostrarAlerta(alerta) {
	return `
	<div class="alert alert-${alerta.nivel} alert-dismissible fade show"
		role="alert">
		${alerta.texto}
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>`
}