package com.dana.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dana.library.domain.Book;
import com.dana.library.domain.User;
import com.dana.library.dto.ResponseDTO;
import com.dana.library.service.BookService;
import com.dana.library.service.InterestedBookService;

import jakarta.servlet.http.HttpSession;

@Controller
public class InterestedBookController {
	
	@Autowired
	private InterestedBookService interestedBookService;
	
	@Autowired
	private BookService bookService;
	
	
	@PostMapping("/book/addInterestedBook/{bookNum}")
	public @ResponseBody ResponseDTO<?> addInterestedBook(@PathVariable int bookNum, HttpSession session){
		Book book = bookService.getBook(bookNum);
		User loginUser = (User) session.getAttribute("loginUser");
		
		interestedBookService.addInterestedBook(book, loginUser);
		return new ResponseDTO<>(HttpStatus.OK.value(), "관심도서 등록 완료");
	}
	
	@DeleteMapping("/book/removeInterestedBook/{bookNum}")
	public @ResponseBody ResponseDTO<?> removeInterestedBook(@PathVariable int bookNum, HttpSession session) {
		Book book = bookService.getBook(bookNum);
		User loginUser = (User) session.getAttribute("loginUser");
		
		interestedBookService.removeInterestedBook(book, loginUser);
		return new ResponseDTO<>(HttpStatus.OK.value(), "관심도서 해제 완료");
	}

}
