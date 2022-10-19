package com.daniel.springJpa.service;

import com.daniel.springJpa.models.Usuario;
import com.daniel.springJpa.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    UsuarioRepo usuarioRepo;
    @Override
    public List<Usuario> listarUsuarios(){
        return usuarioRepo.findAll();
    }

}

