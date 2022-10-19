package com.daniel.springJpa.controllers;

import com.daniel.springJpa.models.Usuario;
import com.daniel.springJpa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/login")
public class AuthController { //control  de sesion


    @Autowired
    UsuarioService usuarioService;

    //debemos verificar que el email y la contraseña sean correctos
    @PostMapping
    public String login(@RequestBody Usuario usuario){
        if(usuarioService.verificarEmailPassword(usuario)){
            return "OK";
        }
        return "FAIL";

    }

}
