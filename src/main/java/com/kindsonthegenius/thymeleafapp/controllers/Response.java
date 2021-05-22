package com.kindsonthegenius.thymeleafapp.controllers;

public class Response {
	
	private String message;
	private String error;
	
	Response(String message, String error){
		this.message = message;
		this.error = error;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getError() {
		return error;
	}
	
	public void setError(String error) {
		this.message = error;
	}

}
 