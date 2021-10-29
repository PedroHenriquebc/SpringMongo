package com.pedrohbc.springmongo.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pedrohbc.springmongo.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{
	
//	@Query("{'cpf' : ?0}")
//	public Optional<Usuario> findByCpf(String cpf);
}
