package com.pedrohbc.springmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrohbc.springmongo.model.Funcionario;
import com.pedrohbc.springmongo.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public List<Funcionario> findAll() {
		return this.funcionarioRepository.findAll();
	}

	public Funcionario findById(String id) {
		return this.funcionarioRepository.findById(id).orElse(null);
	}
	
	public List<Funcionario >findByEmail(String email) {
		return this.funcionarioRepository.findByEmail(email);
	}

	public Funcionario create(Funcionario funcionario) {
		return this.funcionarioRepository.save(funcionario);
	}

	public Funcionario update(String id, Funcionario funcionario) {
		Funcionario oldFuncionario = this.funcionarioRepository.findById(id).orElse(null);;
		if(oldFuncionario != null) {
			oldFuncionario.setName(funcionario.getName());
			oldFuncionario.setEmail(funcionario.getEmail());
			return funcionarioRepository.save(oldFuncionario);
		} else {
			return null;
			}
		}

	public void deleteById(String id) {
		funcionarioRepository.deleteById(id);
	}
}
