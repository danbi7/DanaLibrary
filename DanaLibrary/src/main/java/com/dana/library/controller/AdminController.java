package com.dana.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dana.library.domain.Book;
import com.dana.library.domain.User;
import com.dana.library.dto.ResponseDTO;
import com.dana.library.service.BookService;
import com.dana.library.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;

	
	@GetMapping("/admin/view/home")
	public String adminHome() {
		return "admin/admin";
	}
	
	@GetMapping("/view/admin")
	public String admin(Model model) {
		List<User> userList = userService.getUserList();
		List<Book> bookList = bookService.getBookList();
		model.addAttribute("bookList", bookList);
		model.addAttribute("userList", userList);
		return "admin/admin";
	}

	@GetMapping("/view/myPage")
	public String myPage() {
		return "admin/myPage";
	}
	
	// 회원 정보 수정 기능
	@PutMapping("/user/editUser")
	public @ResponseBody ResponseDTO<?> editUser(@RequestBody User user, HttpSession session){
		userService.editUser(user, session);
		return new ResponseDTO<>(HttpStatus.OK.value(), "회원 정보 수정 완료");
	}

}


