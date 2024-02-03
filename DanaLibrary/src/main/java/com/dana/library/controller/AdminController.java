package com.dana.library.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dana.library.domain.Book;
import com.dana.library.domain.User;
import com.dana.library.dto.ResponseDTO;
import com.dana.library.service.BookService;
import com.dana.library.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
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
	
	
}


