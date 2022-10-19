package com.daniel.springJpa.repository;

import com.daniel.springJpa.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,Integer>{

    //List<Usuario> listarUsuarios();




}
