package com.dana.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dana.library.persistence.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

}
