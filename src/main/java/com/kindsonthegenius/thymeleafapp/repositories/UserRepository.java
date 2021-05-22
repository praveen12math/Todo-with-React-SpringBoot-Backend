package com.kindsonthegenius.thymeleafapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kindsonthegenius.thymeleafapp.model.User;



public interface UserRepository extends MongoRepository<User, String> {
	
	User findByEmail(String email);

	User findByEmailAndPassword(String email, String password);

}
