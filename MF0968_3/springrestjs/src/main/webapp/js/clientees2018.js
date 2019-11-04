// https://dev.to/shoupn/javascript-fetch-api-and-using-asyncawait-47mp

'use strict';

async function mostrarListaProductos() {
	const respuestaTexto = await fetch('http://localhost:8080/api/productos');
	const respuestaJSON = await respuestaTexto.json();
	const productos = respuestaJSON._embedded.productos;
	
	console.log(productos);
	
	const ul = document.querySelector('#productos');
	let li;
	
	for(let producto of productos) {
		li = document.createElement('li');
		li.innerHTML = `${producto.nombre}: ${producto.descripcion} = ${producto.precio}`;
		ul.appendChild(li);
	}
	
	productos.map(
		producto => `${producto.nombre}: (${producto.descripcion}) ${producto.precio}€`
	).forEach( 
		html => {
			li = document.createElement('li');
			li.innerHTML = html;
			ul.append(li);
		} 
	);
		
	console.log(productos.map( function(producto) {
		return `${producto.nombre}: (${producto.descripcion}) ${producto.precio}€`;
	}));
}

window.onload = mostrarListaProductos;

