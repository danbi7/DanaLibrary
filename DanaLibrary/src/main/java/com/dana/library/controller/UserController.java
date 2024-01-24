package com.dana.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dana.library.domain.User;
import com.dana.library.dto.ResponseDTO;
import com.dana.library.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping({"", "/"})
	public String main() {
		return "main";
	}
	
	@GetMapping("/user/findId")
	public String findId() {
		return "/system/findUser";
	}
	
	@PostMapping("/user/findId")
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
	
}
