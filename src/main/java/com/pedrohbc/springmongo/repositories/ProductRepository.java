package com.pedrohbc.springmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pedrohbc.springmongo.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}