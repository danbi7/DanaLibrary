package com.dana.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dana.library.domain.Book;
import com.dana.library.domain.Book_review;
import com.dana.library.domain.User;
import com.dana.library.dto.ResponseDTO;
import com.dana.library.service.BookService;
import com.dana.library.service.ReviewService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ReviewService reviewService;
	
	
	@GetMapping("/book/getBookList")
	public String getBookList() {
		return "book/bookList";
	}
/*
	@GetMapping("/book/getBook")
	public String getBook(HttpSession session) {
		
		List<Book_review> reviewList = reviewService.getReviewList();
		session.setAttribute("reviewList", reviewList);
		return "book/getBook";
	}
*/
	
	@GetMapping("/book/getBook/{bookNum}")
	public String getBook(@PathVariable int bookNum, HttpSession session) {
		
		Book gettedBook = bookService.getBook(bookNum);
		session.setAttribute("gettedBook", gettedBook);
		
		List<Book_review> reviewList = reviewService.getReviewList();
		session.setAttribute("reviewList", reviewList);
		return "book/getBook";
	}
	
	//책 리뷰 등록
	@PostMapping("/review/insertReview")
	public @ResponseBody ResponseDTO<?> insertReview(@RequestBody Book_review review, HttpSession session){
		User loginUser = (User)session.getAttribute("loginUser");
		review.setUser(loginUser);
		reviewService.insertReview(review);
		return new ResponseDTO<>(HttpStatus.OK.value(),"도서 후기 컨트롤러 완료");
	}

}
