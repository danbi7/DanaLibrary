package com.dana.library.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dana.library.domain.User;
import com.dana.library.dto.ResponseDTO;
import com.dana.library.dto.UserDTO;
import com.dana.library.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping({ "", "/" })
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
	
	@GetMapping("/user/insertUser")
	public String insertUser() {
		return "system/register";
	}
	
	@PostMapping("/user/insertUser")
	public @ResponseBody ResponseDTO<?> insertUser(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult) {
	   
	    // 검증 성공 시에만 매핑 및 비즈니스 로직 수행
	    User user = modelMapper.map(userDTO, User.class);
	    User findUser = userService.getUser(user.getUserid());

	    if (findUser != null) {
	        return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "이미 가입한 회원입니다.");
	    }
	    userService.insertUser(user);
	    return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername() + " 님 회원 가입을 축하합니다!");
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
    
	@PostMapping("/user/findUser")
	public @ResponseBody ResponseDTO<?> findUser(@RequestParam String input, HttpSession session) {
		System.out.println("input: " + input);
		User findUser = userService.getUserByIdOrEmail(input);
		System.out.println("findUser: " + findUser.toString());
		
		session.setAttribute("findUser", findUser);
		return new ResponseDTO<>(HttpStatus.OK.value() , "회원 존재");	
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
