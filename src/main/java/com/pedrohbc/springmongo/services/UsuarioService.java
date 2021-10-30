package com.pedrohbc.springmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrohbc.springmongo.model.Usuario;
import com.pedrohbc.springmongo.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario findById(String id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElse(null);
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public List<Usuario> findByCpf(String cpf) {
		List<Usuario> list = usuarioRepository.findByCpf(cpf);
		return list;
	}

//	public Usuario create(Usuario usuario) {
//		return usuarioRepository.save(usuario);
//	}
	
	public Usuario create(Usuario usuario) {
		if(findByCpf(usuario.getCpf()).isEmpty()) {
			return usuarioRepository.save(usuario);
		} else {
			return null;
		}
		
	}

	public Usuario update(String id, Usuario usuario) {
		Usuario newUsuario = findById(id);
		newUsuario.setNome(usuario.getNome());
		newUsuario.setSenha(usuario.getSenha());
		newUsuario.setCpf(usuario.getCpf());
		return usuarioRepository.save(newUsuario);
	}

	public void delete(String id) {
		findById(id);
		usuarioRepository.deleteById(id);
	}

}
