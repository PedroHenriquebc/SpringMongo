package com.pedrohbc.springmongo.model;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuario_collection")
public class Usuario {
	
	@Id
	private String id;
	
	@NotEmpty
	@Length(min = 3, max = 100, message = "Valor entre 3 e 100 caracteres")
	private String nome;
	
	@NotEmpty
	@Length(min = 3, max = 100, message = "Valor entre 3 e 100 caracteres")
	private String senha;
	
	@NotEmpty
	@Length(min = 11, max = 11, message = "CPF deve ter 11 digitos")
	private String cpf;
	
	public Usuario() {
		
	}
	
	public Usuario(String nome,String senha,String cpf) {
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf, other.cpf);
	}
	
	
}
