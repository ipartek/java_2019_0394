/*jslint browser:true, devel:true*/
/*eslint-env browser, es6*/
/*eslint no-console: "off"*/
/*global $*/

$(function () {
    'use strict';
    
    $.getJSON('datos.json').done(function (datos) {
        $(datos).each(function () {
            $('ul').append('<li>' + this.nombre + '</li>');
        });
    }).fail(function () {
        alert('Ha habido un error en el acceso a los datos');
    }).always(function () {
        alert('Proceso completado');
    });
});

/*
function porCadaDato() {
    'use strict';
    
    console.log('Dentro de porCadaDato');
    
    $('ul').append('<li>' + this.nombre + '</li>');
}

function recepcionJSON(datos) {
    'use strict';
    
    console.log('Dentro de recepcionJSON');
    
    $(datos).each(porCadaDato);
}

$(function () {
    'use strict';

    console.log('Antes de getJSON');
    
    $.getJSON('datos.json', recepcionJSON);
    
    console.log('Después de getJSON');
});

*/
