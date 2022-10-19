package com.daniel.springJpa.service;

import com.daniel.springJpa.models.Usuario;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> listarUsuarios();

    void eliminarUsuario(int id);

    void registrarUsuario(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);

}
