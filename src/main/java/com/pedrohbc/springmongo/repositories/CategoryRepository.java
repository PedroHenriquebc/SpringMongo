package com.pedrohbc.springmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pedrohbc.springmongo.model.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

}
