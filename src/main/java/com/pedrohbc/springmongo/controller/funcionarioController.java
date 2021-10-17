package com.pedrohbc.springmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.pedrohbc.springmongo.services.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class funcionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping
	public ResponseEntity<List<Funcionario>> findAll() {
		List<Funcionario> list = this.funcionarioService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Funcionario> findById(@PathVariable String id) {
		Funcionario funcionario = funcionarioService.findById(id);
		if (funcionario == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(funcionario);
		}
	}

	@PostMapping
	public ResponseEntity<Funcionario> createFuncionario(@RequestBody Funcionario funcionario) {
		funcionarioService.create(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(funcionario);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Funcionario> updateFuncionario(@PathVariable String id,
			@RequestBody Funcionario funcionario) {
		Funcionario atualizar = funcionarioService.update(id, funcionario);
		if (atualizar == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(atualizar);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteFuncionarioById(@PathVariable String id) {
		Funcionario funcionario = funcionarioService.findById(id);
		if (funcionario == null) {
			funcionarioService.deleteById(id);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			funcionarioService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}
	}

}