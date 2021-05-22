package com.kindsonthegenius.thymeleafapp.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kindsonthegenius.thymeleafapp.model.Todo;



@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {

	List<Todo> findAllBySecondId(String secondId);

}
