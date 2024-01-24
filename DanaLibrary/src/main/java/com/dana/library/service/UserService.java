package com.dana.library.service;

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
	
	// 이메일로 getUser
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
	
	// 회원가입
	@Transactional
	public void insertUser(User user) {
		user.setUserStatus(Status.ACTIVE);
		userRepository.save(user);
	}
	
	
	// 사용자 아이디로 getUser
	@Transactional(readOnly = true)
	public User getUser(String userid) {
		User findUser = userRepository.findByUserid(userid).orElseGet(()->{
			return new User();
		});
		
		return findUser;
	}
	
	
	// 사용자 아이디 중복 여부
	 @Transactional(readOnly = true)
	  public boolean isUserIdDuplicate(String userid) {
	    return userRepository.existsByUserid(userid);
	  }
  
	//아이디 또는 이메일로 getUser
	@Transactional
	public User getUserByIdOrEmail(String input) {
		User findUser = userRepository.findByEmail(input).orElseGet(() -> userRepository.findByUserid(input).orElse(new User()));

		return findUser;
	}

	// 사용자 비밀번호 변경
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
