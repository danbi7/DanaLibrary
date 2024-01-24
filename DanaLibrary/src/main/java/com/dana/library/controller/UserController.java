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

	@GetMapping("/login")
	public String login() {
		return "system/login";
	}
	
	@PostMapping("/login")
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
}
