package com.daniel.springJpa.service;

import com.daniel.springJpa.models.Usuario;
import com.daniel.springJpa.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
//@Transactional
public class UsuarioService implements IUsuarioService{

    @Autowired
    UsuarioRepo usuarioRepo;

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Usuario> listarUsuarios(){
        return usuarioRepo.findAll();
    }

    @Override
    public void eliminarUsuario(int id) {
        usuarioRepo.deleteById(id);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarioRepo.save(usuario);
    }

    @Override
    public boolean verificarEmailPassword(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email AND password= :password";
        List<Usuario> lista= entityManager.createQuery(query)
                .setParameter("email",usuario.getEmail())
                .setParameter("password",usuario.getPassword())
                .getResultList();

        if(lista.isEmpty()){ //si la lista esta vacia
            return false;
        }else{
            return true;
        }
    }

}

