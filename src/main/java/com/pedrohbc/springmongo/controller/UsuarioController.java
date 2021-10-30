package com.pedrohbc.springmongo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pedrohbc.springmongo.model.Usuario;
import com.pedrohbc.springmongo.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable String id){
		Usuario usuario = this.usuarioService.findById(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> list = this.usuarioService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/cpf")
	public ResponseEntity<List<Usuario>> findByCpf(@RequestParam String cpf){
		List<Usuario> list = this.usuarioService.findByCpf(cpf);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
		Usuario newUsuario = this.usuarioService.create(usuario);
		if(newUsuario != null) {
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUsuario.getId()).toUri();
			return ResponseEntity.created(uri).build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable String id, @RequestBody Usuario usuario){
		Usuario newUsuario = this.usuarioService.update(id, usuario);
		return ResponseEntity.ok().body(newUsuario);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		this.usuarioService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
