// API compatible con todos los navegadores

'use strict';

var READY_STATE_UNINITIALIZED = 0;
var READY_STATE_LOADING = 1;
var READY_STATE_LOADED = 2;
var READY_STATE_INTERACTIVE = 3;
var READY_STATE_COMPLETE = 4;

var peticion_http;

function inicializa_xhr() {
	if (window.XMLHttpRequest) {
		return new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		return new ActiveXObject("Microsoft.XMLHTTP");
	}
}

function cargaContenido(url, metodo, funcion) {
	peticion_http = inicializa_xhr();

	if (peticion_http) {
		peticion_http.onreadystatechange = funcion;
		peticion_http.open(metodo, url, true);
		peticion_http.send(null);
	}
}

// ---------------------------------------------------

var ul;

window.onload = function() {	
	ul = document.getElementById('productos');

	cargaContenido('http://localhost:8080/api/productos', 'GET', mostrarListaProductos);
};

function mostrarListaProductos() {
	if (peticion_http.readyState == READY_STATE_COMPLETE) {
		if (peticion_http.status == 200) {
			var respuesta = JSON.parse(peticion_http.responseText);
			
			var productos = respuesta._embedded.productos;
			
			console.log(productos);
			
			var li;
			
			for(var indice in productos) {
				var producto = productos[indice];
				
				li = document.createElement('li');
				
				li.innerHTML = producto.nombre + ' ' + producto.descripcion + ' ' + producto.precio
				
				//ul.innerHTML += '<li>' + producto.nombre + producto.descripcion + producto.precio + '</li>'
				ul.appendChild(li);					
			}
		}
	}
}