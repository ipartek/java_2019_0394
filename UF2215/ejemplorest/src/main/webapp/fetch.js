const pedirDatos = async () => {
    const response = await fetch('http://localhost:8080/api/alumnos');
    const myJson = await response.json();
    console.log(JSON.stringify(myJson));
}

pedirDatos();
