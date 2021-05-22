package com.kindsonthegenius.thymeleafapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kindsonthegenius.thymeleafapp.model.Todo;
import com.kindsonthegenius.thymeleafapp.model.User;
import com.kindsonthegenius.thymeleafapp.repositories.TodoRepository;
import com.kindsonthegenius.thymeleafapp.repositories.UserRepository;



@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public TodoRepository todoRepository;
	
	
	@RequestMapping("/")
	public String Hello() {
		return "Hello world";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/api/signup")
	public Response signup(@RequestBody User user) {
		if(isEmailFound(user)) {
			Response res = new Response("", "Email is already in use, try another");
			return res;
		}
		else {
			userRepository.insert(user);
			Response res = new Response("Register Success, You can login now", "");
			return res;
		}
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/api/signin")
	public User signin(@RequestBody User user) {
		User found = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if(found != null)
			return found;
		else {
			User res = new User("Invalid credentials","", "","","","");
			return res;
		}
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/api/createTodo")
	public Todo createTodo(@RequestBody Todo todo) {
		Todo createTodos = todoRepository.insert(todo);
		return createTodos;
	}
	
	
	@RequestMapping("/api/getAllTodo/{id}")
	public List<Todo> getTodo(@PathVariable("id") String id){
		List<Todo> allTodo = todoRepository.findAllBySecondId(id);
		return allTodo;
	}
	
	
	@RequestMapping("/api/updateTodo/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable("id") String id) {
		Optional<Todo> todoData = todoRepository.findById(id);
		
		if(todoData.isPresent()) {
			Todo todo = todoData.get();
			todo.setDone(true);
			
			return new ResponseEntity<>(todoRepository.save(todo), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@RequestMapping("/api/deleteTodo/{id}")
	public String deleteTodo(@PathVariable("id") String id) {
		todoRepository.deleteById(id);
		return "Delete success";
	}
	
	
	
	public boolean isEmailFound(@RequestBody User user) {
		if(userRepository.findByEmail(user.getEmail()) != null) {
			return true;
		}
		else {
			return false;
			}	
		}
	
	//public List<User> isSignIn(@RequestBody User user) {
		//if(userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword()) != null)
		//	return true;
		//else
		//	return false;
	//}
	
}
