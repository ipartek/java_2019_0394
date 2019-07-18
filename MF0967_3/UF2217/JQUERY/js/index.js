/*jslint browser:true, devel:true*/
/*eslint-env browser, es6*/
/*eslint no-console: "off"*/

/*globals comprobarLetraNif, $*/

/* Puesto en brackets jslint.options {es6: true} */

$(function () {
    'use strict';

    $('form').submit(function (e) {
        e.preventDefault(); //Evitar propagación de evento

        console.log('Botón pulsado');

        $('#resultado').text($('#nombre').val());

        if (comprobarLetraNif($('#nif').val())) {
            $('#resultado').text(' ' + $('#nif').val());

            $('#nif').removeClass('error');
            
            if ($('#nif + .error').length > 0) {
                $('#nif + .error').remove();
            }
        } else {
            if (!$('#nif').hasClass('error')) {

                $('#resultado').text($('#resultado').text() + ' error en el NIF');

                $('#nif').addClass('error').after('<span class="error">Error en el NIF</span>');
            }
        }
    });
});
