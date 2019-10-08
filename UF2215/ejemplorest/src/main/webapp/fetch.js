'use strict';

const url = 'http://localhost:8080/api/alumnos/';
const alumno = { nombre: 'Luis', apellidos: 'Luisez' };

const insertarAlumno = async (alumno) => {
    try {
        const alumnoInsertado = await postData(url, alumno);
        console.log(alumnoInsertado); // JSON-string from `response.json()` call
    } catch (error) {
        console.error(error);
    }
};

const postData = async (url = '', data = {}) => {
    const response = await fetch(url, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    });
    return await response.json();
};

const pedirDatos = async () => {
    try {
        const response = await fetch(url);
        const alumnos = await response.json();
        console.log(alumnos);
    } catch (error) {
        console.error(error);
    }
};

const procesoGlobal = async () => {
    await insertarAlumno(alumno);
    await pedirDatos();
};

procesoGlobal();
