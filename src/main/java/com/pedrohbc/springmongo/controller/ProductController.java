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

import com.pedrohbc.springmongo.model.Product;
import com.pedrohbc.springmongo.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public List<Product> getAll() {
		return productRepository.findAll();
		
	}
	
	@GetMapping("/{id}")
	public Product getById(@PathVariable String id) {
		return productRepository.findById(id).orElse(null);
	}
	
	@PostMapping
	public Product create(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@PutMapping("/{id}")
	public Product update(@PathVariable String id, @RequestBody Product product) {
		Product oldProduct = productRepository.findById(id).orElse(null);
		oldProduct.setName(product.getName());
		oldProduct.setPrice(product.getPrice());
		oldProduct.setCategory(product.getCategory());
		return productRepository.save(oldProduct);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable String id) {
		productRepository.deleteById(id);
		return id;
	}
}
