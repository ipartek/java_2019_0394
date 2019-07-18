/*jslint browser:true, devel:true*/
/*eslint-env browser, es6*/
/*eslint no-console: "off"*/
/*global $*/

function fallo() {
    'use strict';
    alert('Ha habido un error en el acceso a los datos');
}

function siempre() {
    'use strict';
    console.log('Operación finalizada');
}

$(function () {
    'use strict';

    var url = 'http://localhost:3000/clientes/';
    
    $.post(url, { nombre: 'Juan', apellido: 'Juanes' }, function () {
        console.log('Registro añadido correctamente');
    });
    
    $.ajax({
        url: url + '2',
        method: 'PUT',
        data: { id: 2, nombre: 'Pepito', apellido: 'de los Palotes' }
    }).done(function (dato) {
        console.log('Modificado', dato);
    }).fail(fallo).always(siempre);
    
    $.ajax({
        url: url + '1',
        method: 'DELETE'
    }).done(function (dato) {
        console.log('Borrado', dato);
    }).fail(fallo).always(siempre);
    
    
    $.getJSON(url).done(function (datos) {
        console.log('Recibidos datos');
        $(datos).each(function () {
            $('ul').append('<li>' + this.nombre + '</li>');
        });
    }).fail(fallo).always(siempre);

    $.getJSON(url + '1').done(function (dato) {
        console.log('Recibido dato');
        $('#registro').text(dato.nombre);
    }).fail(fallo).always(siempre);
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
