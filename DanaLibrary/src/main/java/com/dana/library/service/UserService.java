package com.dana.library.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dana.library.domain.Status;
import com.dana.library.domain.User;
import com.dana.library.persistence.UserRepository;

import jakarta.servlet.http.HttpSession;

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
		
		user.setUserStatus(Status.PENDING);
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
	    Optional<User> existingUser = userRepository.findByUserid(userid);
	    return existingUser.isPresent();
	  }
  
	//아이디 또는 이메일로 getUser
	@Transactional
	public User getUserByIdOrEmail(String input) {
		User findUser = userRepository.findByEmail(input)
	            .orElseGet(() -> userRepository.findByUserid(input).orElse(new User()));
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
	
	//전체 회원 불러오기
	@Transactional(readOnly = true)
	public List<User> getUserList(){
		return userRepository.findAll();
	}
	
	
	@Transactional
	public void editUser(User user, HttpSession session) {
		User editUser = (User) session.getAttribute("loginUser");
		
		editUser.setBirthDate(user.getBirthDate());
		editUser.setPassword(user.getPassword());
		editUser.setUsername(user.getUsername());
		
		System.out.println("editUser ------> " + editUser);
		userRepository.save(editUser);
		
		session.setAttribute("loginUser", editUser);
	}
	
	//관리자 회원 수정
	@Transactional
	public void editUserAdmin(User user) {
		
		User editUser = userRepository.findByUserid(user.getUserid()).get();
		editUser.setUserid(user.getUserid());
		editUser.setUsername(user.getUsername());
		editUser.setPassword(user.getPassword());
		editUser.setBirthDate(user.getBirthDate());
		editUser.setUserStatus(user.getUserStatus());
		editUser.setEmail(user.getEmail());
		userRepository.save(editUser);
	}
	
	//이메일 중복 여부
	@Transactional
	public boolean isDuplicateEmail(String eamil) {
		Optional<User> user = userRepository.findByEmail(eamil);
		return user.isPresent();
	}

	@Transactional
	public void deleteUser(User user) {
		user.setUserStatus(Status.INACTIVE);
		userRepository.save(user);
		
	}

}
