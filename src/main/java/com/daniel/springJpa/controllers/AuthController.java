package com.daniel.springJpa.controllers;

import com.daniel.springJpa.models.Usuario;
import com.daniel.springJpa.service.UsuarioService;
import com.daniel.springJpa.utils.JWTUtil;
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

    @Autowired
    JWTUtil jwtUtil;

    //debemos verificar que el email y la contraseña sean correctos (solo recibimos el email y la contraseña)
    @PostMapping
    public String login(@RequestBody Usuario usuario){
        Usuario usuarioLogeado = usuarioService.obtenerUsuarioPorCredenciales(usuario); //null o no
        if(usuarioLogeado != null){
            String token = jwtUtil.create(String.valueOf(usuarioLogeado.getId()),usuarioLogeado.getEmail()); //solo recibe id
            return token;
        }else{
            return "FAIL";
        }




    }

}
