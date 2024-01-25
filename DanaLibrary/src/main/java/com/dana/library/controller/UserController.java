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

	// 메인 페이지
	@GetMapping({ "", "/" })
	public String main() {
		return "main";
	}

	// 회원가입 페이지
	@GetMapping("/user/view/insertUser")
	public String insertUser() {
		return "system/register";
	}

	// 아이디 중복검사 기능
	@PostMapping("/user/checkUserId")
	public @ResponseBody ResponseDTO<?> checkUserId(@RequestBody User user) {
		boolean isDuplicate = userService.isUserIdDuplicate(user.getUserid());

		if (isDuplicate) {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "이미 가입된 아이디입니다.");
		} else {
			return new ResponseDTO<>(HttpStatus.OK.value(), "사용 가능한 아이디입니다.");
		}
	}

	// 회원가입 기능
	@PostMapping("/user/insertUser")
	public @ResponseBody ResponseDTO<?> insertUser(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult) {
	    // 검증 성공 시에만 매핑 및 비즈니스 로직 수행
	    User user = modelMapper.map(userDTO, User.class);
	    userService.insertUser(user);
	    return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername() + " 님 회원 가입을 축하합니다!");
	}

	// 로그인 페이지
	@GetMapping("/user/view/login")
	public String login() {
		return "system/login";
	}

	// 로그인 기능
	@PostMapping("/user/login")
	public @ResponseBody ResponseDTO<?> login(@RequestParam String input, @RequestParam String password, HttpSession session) {
		System.out.println("222" + input + password);
		User findUser = userService.getUserByIdOrEmail(input);
		if (findUser != null) {
			if (password.equals(findUser.getPassword())) {
				session.setAttribute("loginUser", findUser);
				return new ResponseDTO<>(HttpStatus.OK.value(), findUser.getUsername() + "님, 환영합니다.");
			} else {
				return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "회원 정보가 일치하지 않습니다.");
			}
		} else {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "회원 존재하지 않음");
		}
	}

	// 아이디 찾기 페이지
	@GetMapping("/user/view/findUserId")
	public String findUserId() {
		return "/system/findUserId";
	}

	// 아이디 찾기 기능
	@PostMapping("/user/findUserId")
	public @ResponseBody ResponseDTO<?> findId(@RequestBody User user, HttpSession session) {
		System.out.println(user.toString());

		User emailUser = userService.findByEmail(user);
		System.out.println("emailUser" + emailUser);

		if (emailUser.getUsername() != null && emailUser.getBirthDate() != null) {
			System.out.println(emailUser.getUsername() + user.getUsername());
			System.out.println(emailUser.getBirthDate() + " " + user.getBirthDate());
			if (emailUser.getUsername().equals(user.getUsername())
					&& emailUser.getBirthDate().toString().equals(user.getBirthDate().toString())) {
				session.setAttribute("userid", emailUser.getUserid());
				return new ResponseDTO<>(HttpStatus.OK.value(), "아이디 찾기 성공");
			}
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "조건에 맞는 회원 없음");
		} else {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "조건에 맞는 회원 없음");
		}
	}

	// 이메일 인증 페이지
	@GetMapping("/user/view/verifyEmail")
	public String verifyEmail() {
		return "system/verifyEmail";
	}

	// 이메일 또는 아이디로 회원 찾기 기능
	@PostMapping("/user/findUser")
	public @ResponseBody ResponseDTO<?> findUser(@RequestParam String input, HttpSession session) {
		User findUser = userService.getUserByIdOrEmail(input);
		if (findUser != null) {
			session.setAttribute("findUser", findUser);
			return new ResponseDTO<>(HttpStatus.OK.value(), "회원 존재");
		} else {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "회원 존재하지 않음");
		}
	}

	// 비밀번호 수정 페이지
	@GetMapping("/user/view/changePw")
	public String changePassword() {
		return "system/changePw";
	}

	// 비밀번호 변경 기능
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

		// findUser 세션에서 삭제
		session.removeAttribute("findUser");

		return new ResponseDTO<>(HttpStatus.OK.value(), "비밀번호 변경 성공");
	}
	
	// 로그아웃 및 메인이동
	@GetMapping("/user/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
