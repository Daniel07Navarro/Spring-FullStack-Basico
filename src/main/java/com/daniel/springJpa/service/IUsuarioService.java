package com.daniel.springJpa.service;

import com.daniel.springJpa.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    List<Usuario> listarUsuarios();

    void eliminarUsuario(int id);

    void registrarUsuario(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);

    Optional<Usuario> buscarUsuarioPorId(int id);

}
