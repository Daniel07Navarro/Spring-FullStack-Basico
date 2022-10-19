// Call the dataTables jQuery plugin
$(document).ready(function() {

    cargarUsuarios()
  $('#usuarios').DataTable(); //hace que seleccion esa tabla para que tenga paginacion
});

async function cargarUsuarios(){

  const request = await fetch('usuarios', { //se comunica con el controller
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    // PARA HACER LLAMADOS TIPO POST: body: JSON.stringify({a: 1, b: 'Textual content'})
  });
  const usuarios = await request.json();

  console.log(usuarios);
  let listadoHtml = '';
  for(let usuario of usuarios){
        let usuarioHtml= '<tr><td>'+usuario.id+'</td><td>'
        +usuario.nombre+' '+usuario.apellido+'</td><td>'
        +usuario.email+'</td><td>'
        +usuario.telefono
        +'</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';
        listadoHtml += usuarioHtml;
  }


  document.querySelector('#usuarios tbody').outerHTML=listadoHtml;

}

