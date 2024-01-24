package com.dana.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dana.library.domain.User;
import com.dana.library.persistence.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User getUserByIdOrEmail(String userid) {
		User findUser = userRepository.findByEmail(userid);
		if (findUser == null) {
			findUser = userRepository.findByUserid(userid);
		}

		return findUser;
	}

}
