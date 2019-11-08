'use strict';

$(function() {
	$('#refrescarlistado').click(function() {
		$.getJSON('http://localhost:8080/api/ponentes', function(respuesta) {
			console.log(respuesta._embedded.ponentes);
			
			var ponentes = respuesta._embedded.ponentes;
			//var ponente = { id: 1, nombre: 'Javier', experiencia: 'Es profe' };

			var ponente;
			var html = '';
			
			$('.card-group').empty();
			
			$(ponentes).each(function() {
				ponente = this;
				
				html =
				`<div class="card">
					<img class="card-img-top"
						src="http://lorempixel.com/500/500/people/${ponente.id}/Foto de ponente"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">${ponente.nombre}</h5>
						<p class="card-text">${ponente.experiencia}</p>
					</div>
				</div>`;
			
				$('.card-group').append(html)
			});
			
		});
	});
});


/*
			var html =
			'<div class="card">' +
			'	<img class="card-img-top"' +
			'		src="http://lorempixel.com/500/500/people/${ponente.id}/Foto de ponente"' +
			'		alt="Card image cap">' +
			'	<div class="card-body">' +
			'		<h5 class="card-title">${ponente.nombre}</h5>' +
			'		<p class="card-text">${ponente.experiencia}</p>' +
			'	</div>' +
			'</div>';

			html = html
				.replace('${ponente.id}', ponente.id)
				.replace('${ponente.nombre}', ponente.nombre)
				.replace('${ponente.experiencia}', ponente.experiencia);

			console.log(html);
*/