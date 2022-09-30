package com.spring.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.model.User;
import com.spring.security.repository.UserRepository;

@Service
public class UserService {

	@Autowired private UserRepository userRepository;

	public User saveUser(User user) {
		User user1 = null;
		if(user!=null) {
			user1 = this.userRepository.saveAndFlush(user);	
		}
		return user1;
	}
}
