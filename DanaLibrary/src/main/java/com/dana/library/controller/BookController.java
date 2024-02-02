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
import com.dana.library.domain.Status;
import com.dana.library.domain.User;
import com.dana.library.dto.ResponseDTO;
import com.dana.library.service.BookService;
import com.dana.library.service.RentService;
import com.dana.library.service.ReserveService;
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
	
	@Autowired
	private ReserveService reserveService;
	
	//도서 상세보기
	@GetMapping("/book/getBook/{bookNum}")
	public String getBook(@PathVariable int bookNum, HttpSession session, Model model) {
		
		Book gettedBook = bookService.getBook(bookNum);
		session.setAttribute("gettedBook", gettedBook);
		
//		Rent rent = rentService.getRent(gettedBook);
//		if(rent.getRentNum()==0) { //new Rent()
//			rent.setBook(gettedBook);
//		}
//		session.setAttribute("rent", rent);
//		System.out.println(rent.getRentStatus());
		
		User loginUser = (User) session.getAttribute("loginUser");
		int bookStatus = 0;
		
		if(reserveService.isReservedByUser(loginUser, gettedBook)) {
			// 본인이 이미 예약한 도서 -> 예약 취소
			bookStatus = 1;
		}else if(rentService.isRentedBySomeone(loginUser, gettedBook)){
			// 본인이 이미 대출한 도서 -> 반납하기
			bookStatus = 2;
		}else if(rentService.getRent(gettedBook).getRentStatus() != null && rentService.getRent(gettedBook).getRentStatus().equals(Status.ACTIVE)) {
			// 본인이 예약하지 않았고 대출도 하지 않았으나 다른 사람이 대출중 -> 예약하기
			bookStatus = 3;
		}else {
			// 본인이 예약하지 않았고 대출도 하지 않았는데 다른 사람도 대출중이 아님 -> 대출하기
			bookStatus = 4;
		}
		
		System.out.println("bookStatus ----- " + bookStatus);
		model.addAttribute("bookStatus", bookStatus);
		
		//bookNum에 따른 책 리뷰 불러오기
		List<Book_review> reviewList = reviewService.getReviewList(gettedBook);
		session.setAttribute("reviewList", reviewList);
		return "book/getBook";
	}
	
	//책 리뷰 등록
	@PostMapping("/review/insertReview")
	public @ResponseBody ResponseDTO<?> insertReview(@RequestParam String content, HttpSession session) {
		User loginUser = (User)session.getAttribute("loginUser");
		
		Book gettedBook = (Book)session.getAttribute("gettedBook");
		
		Book_review review = new Book_review();
		
		
		review.setUser(loginUser);
		review.setContent(content);
		review.setBook(gettedBook);
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
