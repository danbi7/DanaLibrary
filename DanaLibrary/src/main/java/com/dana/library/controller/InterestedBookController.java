package com.dana.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dana.library.domain.Book;
import com.dana.library.domain.User;
import com.dana.library.service.BookService;
import com.dana.library.service.InterestedBookService;

import jakarta.servlet.http.HttpSession;

@Controller
public class InterestedBookController {
	
	@Autowired
	private InterestedBookService interestedBookService;
	
	@Autowired
	private BookService bookService;
	
	
	@GetMapping("/book/addInterestedBook/{bookNum}")
	public String addInterestedBook(@PathVariable int bookNum, HttpSession session){
		Book book = bookService.getBook(bookNum);
		User loginUser = (User) session.getAttribute("loginUser");
		
		interestedBookService.addInterestedBook(book, loginUser);
		return "redirect:/public/book/view/getBookList";
	}
	
	@GetMapping("/book/removeInterestedBook/{bookNum}")
	public String removeInterestedBook(@PathVariable int bookNum, HttpSession session) {
		Book book = bookService.getBook(bookNum);
		User loginUser = (User) session.getAttribute("loginUser");
		
		interestedBookService.removeInterestedBook(book, loginUser);
		return "redirect:/public/book/view/getBookList";
	}

}
