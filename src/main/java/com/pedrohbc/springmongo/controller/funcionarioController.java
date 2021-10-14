package com.pedrohbc.springmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrohbc.springmongo.model.Funcionario;
import com.pedrohbc.springmongo.repositories.FuncionarioRepository;

@RestController
@RequestMapping("/funcionarios")
public class funcionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping
	public List<Funcionario> obterTodos() {
		return this.funcionarioRepository.findAll();
	}
	
}
