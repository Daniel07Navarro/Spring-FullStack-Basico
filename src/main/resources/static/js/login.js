// Call the dataTables jQuery plugin
$(document).ready(function() {

  // on ready
});

async function iniciarSesion(){

    let datos = {};
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

  const request = await fetch('api/login', { //se comunica con el controller
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    // PARA HACER LLAMADOS TIPO POST:
    body: JSON.stringify(datos) //Agrega un objeto de Js y lo convierte a un String de Json
  });
  const respuesta = await request.text();
    if(respuesta != 'FAIL'){
        localStorage.token = respuesta;
        localStorage.email = datos.email;
        window.location.href= "usuarios.html"; //si es un OK te va a mandar a la pagina de usuarios
    }else{
        alert('Datos incorrectos');
    }
}

