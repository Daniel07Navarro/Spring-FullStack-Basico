// Call the dataTables jQuery plugin
$(document).ready(function() {

    cargarUsuarios()
  $('#usuarios').DataTable(); //hace que seleccion esa tabla para que tenga paginacion
  cargarNombreUsuario();
});

function cargarNombreUsuario(){
    document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}

function getHeaders() {
    return {
     'Accept': 'application/json',
     'Content-Type': 'application/json',
     'Authorization': localStorage.token
   };
}
async function cargarUsuarios(){

  const request = await fetch('api/usuarios', { //se comunica con el controller
    method: 'GET',
    headers: getHeaders()
    // PARA HACER LLAMADOS TIPO POST: body: JSON.stringify({a: 1, b: 'Textual content'})
  });
  const usuarios = await request.json();

  console.log(usuarios);
  let listadoHtml = '';
  for(let usuario of usuarios){
        let botonEliminar = '<a href="#" onclick="eliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
        let usuarioHtml= '<tr><td>'+usuario.id+'</td><td>'
        +usuario.nombre+' '+usuario.apellido+'</td><td>'
        +usuario.email+'</td><td>'
        +usuario.telefono
        +'</td><td>'+botonEliminar+'</td></tr>';
        listadoHtml += usuarioHtml;
  }


  document.querySelector('#usuarios tbody').outerHTML=listadoHtml;




}
/*
async function buscarPorId(){
    const request = await fetch('api/usuarios/buscarId', { //se comunica con el controller
        method: 'GET',
        headers: getHeaders()
        // PARA HACER LLAMADOS TIPO POST: body: JSON.stringify({a: 1, b: 'Textual content'})
    });
    const usuarios = await request.json();
    console.log(usuarios);
    let id = document.getElementById('txtBuscarId').value;
    listadoHtml = '';
    for(let usuario of usuarios){
        let botonEliminar = '<a href="#" onclick="eliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
        let usuarioHtml= '<tr><td>'+usuario.id+'</td><td>'
            +usuario.nombre+' '+usuario.apellido+'</td><td>'
            +usuario.email+'</td><td>'
            +usuario.telefono
            +'</td><td>'+botonEliminar+'</td></tr>';
        listadoHtml += usuarioHtml;
    }
    document.querySelector('#usuarios tbody').outerHTML=listadoHtml;

}
*/


async function eliminarUsuario(id){

    //HACEMOS UN CARTEL PARA VALIDAR LA ELIMINIACION
    if(!confirm('¿Desea eliminar este usuario?')){
        return ;
    }

    const request = await fetch('api/usuarios/' + id, { //se comunica con el controller
            method: 'DELETE',
            headers: getHeaders()
            // PARA HACER LLAMADOS TIPO POST: body: JSON.stringify({a: 1, b: 'Textual content'})

  });
    location.reload(); //para cargar la pagina
}

