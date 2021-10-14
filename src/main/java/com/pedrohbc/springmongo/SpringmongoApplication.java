package com.pedrohbc.springmongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedrohbc.springmongo.model.Funcionario;
import com.pedrohbc.springmongo.repositories.FuncionarioRepository;


@SpringBootApplication
public class SpringmongoApplication implements CommandLineRunner{
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringmongoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Funcionario f1 = new Funcionario("joao", "joao@gmail.com");
		funcionarioRepository.save(f1);
		
	}

}
