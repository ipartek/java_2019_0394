'use strict';

var URL = 'http://localhost:8080/api/productos/';

jQuery(alCargarDocumento());

function alCargarDocumento() {
    return function($) {
        $('button').click(onClick($));
        listarProductos($);
    };
}

function onClick($) {
    return function(e) {
        e.preventDefault(); //Cancelar la emisión del formulario por el action

        var nombre = $('#nombre').val();
        var descripcion = $('#descripcion').val();
        var precio = $('#precio').val();
        
		var producto = { nombre, descripcion, precio };

        console.log(producto);
        
		var opcionesAjax = {
            url: URL,
            method: 'POST',
            data: JSON.stringify(producto),
            contentType: 'application/json',
            dataType: 'json'
        };
        
		var post$ = $.ajax(opcionesAjax);
		post$.done(onPostCorrecto($, producto));
		post$.fail(onPostIncorrecto());
    };
}

function onPostIncorrecto() {
    return function(jqXHR, textStatus, errorThrown) {
        alert(jqXHR.responseJSON.message);
        console.log(jqXHR, textStatus, errorThrown);
    };
}

function onPostCorrecto($, producto) {
    return function(respuesta) {
        console.log(respuesta);
        addProductoAListado($, producto);
    };
}

function listarProductos($) {
	$('#productos').empty();

	$.getJSON(URL, onGetCorrecto($));
}

function onGetCorrecto($) {
    return function(respuesta) {
        var productos = respuesta._embedded.productos;
        console.log(productos);
        $(productos).each(porCadaProducto($));
    };
}

function porCadaProducto($) {
    return function() {
        console.log(this);
        addProductoAListado($, this);
    };
}

function addProductoAListado($, producto) {
	var li$ = $('<li>');
	
	li$.html(
		producto.nombre + ' ' + producto.descripcion + ' ' + producto.precio
	);
	
	li$.appendTo('#productos');
}
