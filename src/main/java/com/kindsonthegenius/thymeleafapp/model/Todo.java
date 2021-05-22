package com.kindsonthegenius.thymeleafapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="todo")
public class Todo {
	
	@Id
	private String id;
	private String secondId;
	private boolean done;
	private String description;
	
	public Todo() {
		super();
	}
	
	public Todo(String secondId, boolean done, String description) {
		super();
		this.secondId = secondId;
		this.done = done;
		this.description = description;
	}
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getSecondId() {
		return secondId;
	}
	
	public void setSecondId(String secondId) {
		this.secondId = secondId;
	}
	
	public boolean getDone() {
		return done;
	}
	
	public void setDone(boolean done) {
		this.done = done;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
