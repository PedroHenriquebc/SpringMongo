package com.pedrohbc.springmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pedrohbc.springmongo.model.Funcionario;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String>{

}
