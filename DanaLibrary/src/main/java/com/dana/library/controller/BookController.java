package com.dana.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dana.library.domain.Book;
import com.dana.library.domain.Book_review;
import com.dana.library.domain.Rent;
import com.dana.library.domain.User;
import com.dana.library.dto.ResponseDTO;
import com.dana.library.service.BookService;
import com.dana.library.service.RentService;
import com.dana.library.service.ReviewService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private RentService rentService;
	
	//도서 상세보기
	@GetMapping("/book/getBook/{bookNum}")
	public String getBook(@PathVariable int bookNum, HttpSession session) {
		
		Book gettedBook = bookService.getBook(bookNum);
		session.setAttribute("gettedBook", gettedBook);
		
		Rent rent = rentService.getRent(gettedBook);
		if(rent.getRentNum()==0) { //new Rent()
			rent.setBook(gettedBook);
		}
		session.setAttribute("rent", rent);
		System.out.println(rent.getRentStatus());
		
		List<Book_review> reviewList = reviewService.getReviewList();
		session.setAttribute("reviewList", reviewList);
		return "book/getBook";
	}
	
	//책 리뷰 등록
	@PostMapping("/review/insertReview")
	public @ResponseBody ResponseDTO<?> insertReview(@RequestParam String content, HttpSession session){
		User loginUser = (User)session.getAttribute("loginUser");
		
		Book_review review = new Book_review();
		review.setUser(loginUser);
		review.setContent(content);
		System.out.println("review : " + review.toString());
		reviewService.insertReview(review);
		return new ResponseDTO<>(HttpStatus.OK.value(),"도서 후기 컨트롤러 완료");
	}

	/*
	 @PostMapping("/review/insertReview")
		public @ResponseBody ResponseDTO<?> insertReview(@RequestParam Book_review review, HttpSession session){
		User loginUser = (User)session.getAttribute("loginUser");
		review.setUser(loginUser);
		reviewService.insertReview(review);
		return new ResponseDTO<>(HttpStatus.OK.value(),"도서 후기 컨트롤러 완료");
	}
	 */
	
	//도서목록
	@GetMapping("/book/view/getBookList")
	public String getBookList(Model model) {
		List<Book> bookList = bookService.getBookList();
		model.addAttribute("bookList", bookList);
		return "book/bookList";
	}
	
	

}
