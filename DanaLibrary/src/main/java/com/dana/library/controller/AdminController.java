package com.dana.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//관리자페이지 불러오기
	@GetMapping("/view/admin")
	public String admin(Model model) {
		List<User> userList = userService.getUserList();
		List<Book> bookList = bookService.getBookList();
		model.addAttribute("bookList", bookList);
		model.addAttribute("userList", userList);
		return "admin/admin";
	}
	
	//마이페이지
	@GetMapping("/view/myPage")
	public String myPage() {
		return "admin/myPage";
	}
	
	//회원 수정 상세 페이지 불러오기
	@GetMapping("/view/userEdit/{userid}")
	public String openEditUser(@PathVariable String userid, Model model) {
	    User user = userService.getUser(userid);
	    System.out.println(user.getUsername() + "의 정보 불러오기");
	    model.addAttribute("user", user);
	    return "admin/userEdit";
	}
	
	//관리자 회원 수정 기능
	@PutMapping("/admin/editUser")
	public @ResponseBody ResponseDTO<?> editUserAdmin(@RequestBody User user){
		userService.editUserAdmin(user);
		return new ResponseDTO<>(HttpStatus.OK.value(), "회원 정보 수정 완료");
	}
	
	// 회원 정보 수정 기능
	@PutMapping("/user/editUser")
	public @ResponseBody ResponseDTO<?> editUser(@RequestBody User user, HttpSession session){
		userService.editUser(user, session);
		return new ResponseDTO<>(HttpStatus.OK.value(), "회원 정보 수정 완료");
	}

}


