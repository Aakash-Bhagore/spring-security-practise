package com.spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.dto.Response;
import com.spring.security.model.User;
import com.spring.security.service.UserService;

@RestController
@RequestMapping("/user")
public class Rest {
	
	@Autowired private UserService service;
	
	
	@GetMapping("/welcome")
	public String getData() {
		String msg = "Welcome to spring security bank.";
		return msg;
	}
	
	@GetMapping("/home")
	public String getHome() {
		return "Welcome to webkorps bank.";
	}
	
	@GetMapping("/balance")
	public String getBalance() {
		return "Your balance is $14000 ";
	}
	
	@GetMapping("/statement")
	public String getStatement() {
		return "Your account statement is send to your email.";
	}
	
	@GetMapping("/myloan") 
	public String showLoanDetails() {
		return "Your loan due amount is $10000.";
	}
	
	@GetMapping("/contact")
    public String getContact() {
		return "We are always here to help just call us on this number only after morning.";
	}
	@PostMapping("/save")
	public Response saveUserData(@RequestBody User user) {
		Response response = new Response();
		System.out.println("User:- "+user);
		User user1 = service.saveUser(user);
		if(user1!=null) {
			response.setObject(user1);
			response.setStatus("success");
			response.setStatusCode(1);
		} else {
			response.setObject(user1);
			response.setStatus("failure");
			response.setStatusCode(0);
		}
		return response;
	}
	
	@GetMapping("/form")
	public String getUser() {
		return "User";
	}
}
