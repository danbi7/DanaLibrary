package com.dana.library.service;

import java.sql.Date;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dana.library.domain.User;
import com.dana.library.persistence.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Transactional(readOnly = true)
	public User findByEmail(User user) {
		System.out.println("111111");
		User findUser = userRepository.findByEmail(user.getEmail()).orElseGet(new Supplier<User>(){
			public User get() {
				return new User();
			}
		});
		return findUser;
	}
	
	
}
