package com.daniel.springJpa.service;

import com.daniel.springJpa.models.Usuario;
import com.daniel.springJpa.repository.UsuarioRepo;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

    @Override //para el login pero debe retornar un usuario para poder crear el token
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista= entityManager.createQuery(query)
                .setParameter("email",usuario.getEmail())
                .getResultList();

        if(lista.isEmpty()){ //para evitar el nullpointer
            return null;
        }

        //va a verificar las contraseñas
        String passwordHashed = lista.get(0).getPassword(); //la contraseña de la base de datos
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        //Si esta correctamente verficada te va a retornar un true
        boolean verificar = argon2.verify(passwordHashed,usuario.getPassword()); //verifica la contraseña de la base de datos (encriptada) con la que se esta poniendo
        if(verificar){
            return lista.get(0); //el primero de la lista
        }
        return null;



    }

}

