'use strict';

var URL = 'http://localhost:8080/api/productos/';

jQuery(function($) { //Equivalente a window.onload
	$('button').click(function(e) {
		e.preventDefault(); //Cancelar la emisión del formulario por el action

		var nombre = $('#nombre').val();
		var descripcion = $('#descripcion').val();
		var precio = $('#precio').val();

		var producto = { nombre, descripcion, precio };

		console.log(producto);

		$.ajax({
			url: URL,
			method: 'POST',
			data: JSON.stringify(producto),
			contentType: 'application/json',
			dataType: 'json'
		}).done(function(respuesta) {
			console.log(respuesta);
			addProductoAListado($, producto);
		}).fail(function(jqXHR, textStatus, errorThrown) {
			alert(jqXHR.responseJSON.message);
			console.log(jqXHR, textStatus, errorThrown);
		});
	});

	listarProductos($);
});

function listarProductos($) {
	$('#productos').empty();

	$.getJSON(URL, function(respuesta) {
		var productos = respuesta._embedded.productos;
		console.log(productos);
		$(productos).each(function() {
			console.log(this);
			addProductoAListado($, this);
		});
	});
}

function addProductoAListado($, producto) {
	$('#productos').append($('<li>').html(
		producto.nombre + ' ' + producto.descripcion + ' ' + producto.precio));
}
