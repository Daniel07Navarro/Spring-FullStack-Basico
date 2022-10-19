// Call the dataTables jQuery plugin
$(document).ready(function() {

  // on ready
});

async function registrarUsuarios(){


    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;
    datos.telefono = document.getElementById('txtTelefono').value;

    let repetirContraseña = document.getElementById('txtRepetirPassword').value;
    if(repetirContraseña != datos.password){
        alert('Contraseñas diferentes');
        return; //para que no se ejecute mas
    }


  const request = await fetch('api/usuarios', { //se comunica con el controller
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    // PARA HACER LLAMADOS TIPO POST:
    body: JSON.stringify(datos) //Agrega un objeto de Js y lo convierte a un String de Json
  });

}


