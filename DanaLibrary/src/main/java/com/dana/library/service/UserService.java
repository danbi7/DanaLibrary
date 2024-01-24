package com.dana.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dana.library.domain.Status;
import com.dana.library.domain.User;
import com.dana.library.persistence.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void insertUser(User user) {
		user.setUserStatus(Status.ACTIVE);
		userRepository.save(user);
	}
	
	@Transactional(readOnly = true)
	public User getUser(String userid) {
		User findUser = userRepository.findByUserid(userid).orElseGet(()->{
			return new User();
		});
		
		return findUser;
	}
	
	 @Transactional(readOnly = true)
	  public boolean isUserIdDuplicate(String userid) {
	    // 사용자 아이디가 중복되는지 확인
	    return userRepository.existsByUserid(userid);
	  }

}
