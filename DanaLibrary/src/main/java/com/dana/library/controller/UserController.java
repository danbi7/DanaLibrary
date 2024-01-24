package com.dana.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dana.library.domain.User;
import com.dana.library.dto.ResponseDTO;
import com.dana.library.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping({ "", "/" })
	public String main() {
		return "main";
	}
	
	@GetMapping("/user/view/findUserId")
	public String findUserId() {
		return "/system/findUser";
	}
	
	@PostMapping("/user/findUserId")
	public @ResponseBody ResponseDTO<?> findId(@RequestBody User user, HttpSession session) {
		System.out.println(user.toString());
		
		User emailUser = userService.findByEmail(user);
		System.out.println("emailUser" + emailUser);
		
		
		if(emailUser.getUsername() != null && emailUser.getBirthDate() != null) {
			System.out.println(emailUser.getUsername() + user.getUsername());
			System.out.println(emailUser.getBirthDate() + " " + user.getBirthDate());
			if(emailUser.getUsername().equals(user.getUsername()) && emailUser.getBirthDate().toString().equals(user.getBirthDate().toString())){
				session.setAttribute("emailUser",emailUser);
				return new ResponseDTO<>(HttpStatus.OK.value(),"아이디 찾기 성공");
			}
				return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(),"조건에 맞는 회원 없음");
		}else {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(),"조건에 맞는 회원 없음");
		}
	}
		
	@GetMapping("/user/view/insertUser")
	public String insertUser() {
		return "system/register";
	}
	
	@PostMapping("/user/insertUser")
	public @ResponseBody ResponseDTO<?> insertUser(@RequestBody User user){
		User findUser = userService.getUser(user.getUserid());
		
		if(findUser.getUserid() == null) {
			userService.insertUser(user);
			return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername()+
					" 님 회원 가입을 축하합니다!");
		} else {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), user.getUsername()
					+ "님은 이미 가입하신 회원입니다.");
		}
	}
	
	  @PostMapping("/user/checkUserId")
	  public @ResponseBody ResponseDTO<?> checkUserId(@RequestBody User user) {
	    boolean isDuplicate = userService.isUserIdDuplicate(user.getUserid());

	    if (isDuplicate) {
	      return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "이미 가입된 아이디입니다.");
	    } else {
	      return new ResponseDTO<>(HttpStatus.OK.value(), "사용 가능한 아이디입니다.");
	    }
	  }

	@GetMapping("/user/view/verify")
	public String verify() {
		return "system/verifyEmail";
	}

	@GetMapping("/user/view/changePw")
	public String changePassword() {
		return "system/changePw";
	}

	@GetMapping("/user/view/login")
	public String login() {
		return "system/login";
	}
	
	@PostMapping("/user/login")
	public @ResponseBody ResponseDTO<?> login(@RequestBody User user, HttpSession session) {
		System.out.println("안녕하세요");
		System.out.println(user.getUserid());
		User findUser = userService.getUserByIdOrEmail(user.getUserid());	
		if (findUser != null) {
			if (user.getPassword().equals(findUser.getPassword())) {
				session.setAttribute("findUser", findUser);
				return new ResponseDTO<>(HttpStatus.OK.value(), findUser.getUsername() + "님, 환영합니다.");
			} else {
				return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "회원 정보가 일치하지 않습니다.");
			}
		} else {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "회원 존재하지 않음");
		}
	}
    
	@PostMapping("/user/findUser")
	public @ResponseBody ResponseDTO<?> findUser(@RequestParam String input, HttpSession session) {
		User findUser = userService.getUserByIdOrEmail(input);
		if(findUser != null) {
			session.setAttribute("findUser", findUser);
			return new ResponseDTO<>(HttpStatus.OK.value() , "회원 존재");
		}
		else {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value() , "회원 존재하지 않음");
		}
	}
	
	@PutMapping("/user/changePw")
	public @ResponseBody ResponseDTO<?> changePw(@RequestParam String password, HttpSession session) {
	    // 세션에서 사용자 정보를 가져옴
	    User user = (User) session.getAttribute("findUser");

	    // 세션에서 사용자 정보가 없거나 새로 입력받은 비밀번호가 null 이면 오류 처리
	    if (user == null || password == null) {
	        return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "비밀번호 변경 실패");
	    }
	    user.setPassword(password);
	    userService.changepw(user);
	    
	    //findUser 세션에서 삭제
	    session.removeAttribute("findUser");
	    
	    return new ResponseDTO<>(HttpStatus.OK.value(), "비밀번호 변경 성공");
	}
	
}
