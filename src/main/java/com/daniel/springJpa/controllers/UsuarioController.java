package com.daniel.springJpa.controllers;


import com.daniel.springJpa.models.Usuario;
import com.daniel.springJpa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //maneja las url
@RequestMapping(path = "api/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @PostMapping
    public void insertarUsuario(@RequestBody Usuario usuario){ //Para convertir el Json a un objeto en Java
        usuarioService.registrarUsuario(usuario);
    }

    @DeleteMapping(path = "/{id}") //Para poder eliminar con el id
    public void eliminarUsuario(@PathVariable int id){
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
