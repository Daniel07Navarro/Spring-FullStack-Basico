package com.daniel.springJpa.controllers;


import com.daniel.springJpa.models.Usuario;
import com.daniel.springJpa.service.UsuarioService;
import com.daniel.springJpa.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //maneja las url
@RequestMapping(path = "api/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    JWTUtil jwtUtil;

    @GetMapping
    public List<Usuario> listarUsuarios(@RequestHeader(value = "Authorization") String token){

        //DEBEMOS VERIFICAR QUE EL TOKEN SEA EL CORRECTO
        String idUsuario = jwtUtil.getKey(token); //extraer el id del usuario
        if(!validarToken(token)){
            return null; //devuelve una lista vacia
        }

        return usuarioService.listarUsuarios();
    }

    private boolean validarToken(String token){
        String idUsuario = jwtUtil.getKey(token);
        if(idUsuario != null){
            return true;
        }else{
            return false;
        }
    }

    @PostMapping //al momento de hacer el registro
    public void registrarUsuario(@RequestBody Usuario usuario){ //Para convertir el Json a un objeto en Java
        //Para poder encryptar la contraseña
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id); //
        String hash = argon2.hash(1,1024,1,usuario.getPassword());
        usuario.setPassword(hash); //vamos a dar la nueva contraseña ecriptada

        usuarioService.registrarUsuario(usuario);
    }

    @DeleteMapping(path = "/{id}") //Para poder eliminar con el id
    public void eliminarUsuario(@RequestHeader(value = "Authorization") String token ,@PathVariable int id){
        if(!validarToken(token)){
            return ; //devuelve una lista vacia
        }
        usuarioService.eliminarUsuario(id);
    }



    /*
    @GetMapping /PRUEBA
    public List<Usuario> listarUsuarios(){
        Usuario usuario = new Usuario(1,"Daniel","Navarro","daniel@gmail.com","99403731","aa");
        Usuario usuario2 = new Usuario();
        usuario2.setId(2);
        usuario2.setNombre("Pedro");
        usuario2.setApellido("Juancho");
        usuario2.setEmail("pedro@gmail.com");
        usuario2.setTelefono("995645125");
        usuario2.setPassword("*******");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario);
        usuarios.add(usuario2);
        return usuarios;
    }

    @GetMapping(path = "/{id}")
    public Usuario listarUsuario(@PathVariable int id){
        Usuario usuario = new Usuario(id,"Daniel","Navarro","daniel@gmail.com","99403731","aa");
        return usuario;
    }


    */





}
