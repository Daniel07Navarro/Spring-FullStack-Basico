package com.daniel.springJpa;

import com.daniel.springJpa.models.Usuario;
import com.daniel.springJpa.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}




	@Override
	public void run(String... args) throws Exception {

	}
}
