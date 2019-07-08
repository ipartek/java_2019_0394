/*jslint browser:true, devel:true*/
/*eslint-env browser, es6*/
/*eslint no-console: "off"*/

/*globals comprobarLetraNif*/

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

        var inputNombre, resultado, inputNif, span;

        console.log('Botón pulsado');

        inputNombre = document.getElementById('nombre');

        console.log(inputNombre.value);

        resultado = document.getElementById('resultado');

        resultado.innerHTML = inputNombre.value;

        inputNif = document.getElementById('nif');

        if (comprobarLetraNif(inputNif.value)) {
            resultado.innerHTML += ' ' + inputNif.value;

            inputNif.className = '';
            
            if (inputNif.mensajeError) {
                inputNif.parentNode.removeChild(inputNif.mensajeError);

                delete inputNif.mensajeError;
            }
        } else {
            if (inputNif.className !== 'error') {

                resultado.innerHTML += ' error en el NIF';

                inputNif.className = 'error';

                //inputNif.parentNode.innerHTML += '<span class="error">ERROR EN EL NIF</span>';

                span = document.createElement('span');
                span.className = 'error';
                span.innerHTML = 'Error en el NIF';
                inputNif.parentNode.appendChild(span);
                
                inputNif.mensajeError = span;
            }
        }

        //resultado.innerHTML += comprobarLetraNif(inputNif.value) ? ' ' + inputNif.value : ' error en el NIF';

        //return false; //Evitar propagación de evento
    };
};
