package com.dana.library.service;

import java.sql.Date;
import java.util.function.Supplier;

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
  
	//아이디 또는 이메일로 getUser
	@Transactional
	public User getUserByIdOrEmail(String input) {
		User findUser = userRepository.findByEmail(input).get();
		if (findUser == null) {
			findUser = userRepository.findByUserid(input).get();
		}

		return findUser;
	}

	@Transactional
	public void changepw(User user) {
	    User findUser = userRepository.findByUserid(user.getUserid()).get();

	    if (findUser != null) {
	        findUser.setPassword(user.getPassword());
	        userRepository.save(findUser);
	    } else {
	        throw new RuntimeException("사용자가 존재하지 않습니다.");
	    }
	}

}
