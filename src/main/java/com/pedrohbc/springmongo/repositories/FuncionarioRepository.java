package com.pedrohbc.springmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pedrohbc.springmongo.model.Funcionario;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {

	@Query("{'email' : ?0}")
	public List<Funcionario> findByEmail(String email);
}
