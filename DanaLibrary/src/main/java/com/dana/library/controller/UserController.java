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
	
	@GetMapping("/user/insertUser")
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
