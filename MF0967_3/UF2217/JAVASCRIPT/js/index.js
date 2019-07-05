/*jslint browser:true, devel:true*/
/*eslint-env browser, es6*/
/*eslint no-console: "off"*/

/* Puesto en brackets jslint.options {es6: true} */
console.log('Dentro de <script>');

function demoJS() {
    'use strict';
    console.log('Antes de Hola');
    
    //alert('Hola');
    
    console.log('Después de Hola');
    
    //document.write('<h1>Prueba</h1>');
    
    var titulo = document.getElementsByTagName('h1')[0],
        texto = titulo.innerHTML;
    
    titulo.innerHTML = texto + ' cambiado';
    
}

window.onload = function () {
    'use strict';
    demoJS();
    
    document.forms[0].onsubmit = function (e) {
        e.preventDefault(); //Evitar propagación de evento
        
        var inputNombre, resultado;
        
        console.log('Botón pulsado');
        
        inputNombre = document.getElementById('nombre');
        
        console.log(inputNombre.value);
        
        resultado = document.getElementById('resultado');
        
        resultado.innerHTML = inputNombre.value;
        
        //return false; //Evitar propagación de evento
    };
};
    
