package com.daniel.springJpa.controllers;


import com.daniel.springJpa.models.Usuario;
import com.daniel.springJpa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //maneja las url
@RequestMapping(path = "usuarios")
public class UsuarioController {


    @Autowired
    UsuarioService usuarioService;

    /*
    @GetMapping
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
    */
    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @GetMapping(path = "/{id}")
    public Usuario listarUsuario(@PathVariable int id){
        Usuario usuario = new Usuario(id,"Daniel","Navarro","daniel@gmail.com","99403731","aa");
        return usuario;
    }


}
