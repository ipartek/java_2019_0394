'use strict';

$(function() { //Equivalente a window.onload
	$.getJSON('http://localhost:8080/api/productos', function(respuesta) {
		var productos = respuesta._embedded.productos;
		
		console.log(productos);
		
		$(productos).each(function() {
			console.log(this);
			
			$('#productos').append($('<li>').html(
					this.nombre + ' ' + this.descripcion + ' ' + this.precio));
		});
	});
});
