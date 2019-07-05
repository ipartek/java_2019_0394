/*jslint browser:true, devel:true*/
/*eslint no-unused-vars: "off"*/
/*eslint-env browser, es6*/
/*eslint no-console: "off"*/

function transformarLetraExtranjeroEnNumero(numero) {
    'use strict';
    
    var letra = numero[0];
    
    switch (letra) {
    case 'X':
        return numero.replace('X', '0');
    case 'Y':
        return numero.replace('Y', '1');
    case 'Z':
        return numero.replace('Z', '2');
    }
    
    return numero;
}

function calcularLetraNif(numero) {
    'use strict';
    
    //numero = parseInt(numero);
    
    //if(isNaN(numero)){
    //    return false;
    //}
    
    var letras = 'TRWAGMYFPDXBNJZSQVHLCKE',
        resto,
        posicion;
    
    //posicion = 'XYZ'.indexOf(letraExtrangero);
    //if (posicion) {//if (/[XYZ]/.test(numero[0])) {
    //    numero[0] = posicion;
    //}
    
    //numero[0] = posicion < 0 ? numero[0] : posicion;
        
    return letras[transformarLetraExtranjeroEnNumero(numero) % 23];
}

function comprobarLetraNif(nif) {
    'use strict';
    var regex, letra, numero;
    
    regex = /^[XYZ\d]\d{7}[TRWAGMYFPDXBNJZSQVHLCKE]$/;
    
    if (!regex.test(nif)) {
        return false;
    }
    
    letra = nif[8];
    numero = nif.substr(0, 8);
    
    console.log(letra);
    console.log(numero);
    
    return letra === calcularLetraNif(numero);
}