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
	
	//아이디 또는 이메일로 getUser
	@Transactional
	public User getUserByIdOrEmail(String input) {
		User findUser = userRepository.findByEmail(input);
		if (findUser == null) {
			findUser = userRepository.findByUserid(input);
		}

		return findUser;
	}

	@Transactional
	public void changepw(User user) {
	    User findUser = userRepository.findByUserid(user.getUserid());

	    if (findUser != null) {
	        findUser.setPassword(user.getPassword());
	        userRepository.save(findUser);
	    } else {
	        throw new RuntimeException("사용자가 존재하지 않습니다.");
	    }
	}
}
