package com.pedrohbc.springmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public List<Funcionario> findAll() {
		return this.funcionarioRepository.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Funcionario findById(@PathVariable String id) {
		return this.funcionarioRepository.findById(id).orElse(null);
	}
	
	@PostMapping
	public Funcionario post(@RequestBody Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	@PutMapping(value="/{id}")
	public Funcionario put(@PathVariable String id, @RequestBody Funcionario funcionario) {
		Funcionario oldFuncionario = funcionarioRepository.findById(id).orElse(null);
		oldFuncionario.setName(funcionario.getName());
		oldFuncionario.setEmail(funcionario.getEmail());
		return funcionarioRepository.save(oldFuncionario);
	}
	
	@DeleteMapping(value="/{id}")
	public String delete(@PathVariable String id) {
		funcionarioRepository.deleteById(id);
		return id;
	}
	
	
}
