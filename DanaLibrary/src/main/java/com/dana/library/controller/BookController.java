package com.dana.library.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dana.library.domain.Book;
import com.dana.library.domain.Book_review;
import com.dana.library.domain.Interested_book;
import com.dana.library.domain.Rent;
import com.dana.library.domain.User;
import com.dana.library.dto.ResponseDTO;
import com.dana.library.service.BookService;

import com.dana.library.service.InterestedBookService;
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

	@Autowired
	private InterestedBookService interestedBookService;
	
	// 도서 상세보기
	@GetMapping("/book/getBook/{bookNum}")
	public String getBook(@PathVariable int bookNum, HttpSession session, Model model) {

		Book gettedBook = bookService.getBook(bookNum);
		session.setAttribute("gettedBook", gettedBook);
		User loginUser = (User) session.getAttribute("loginUser");
		int bookStatus = 0;

		if (reserveService.isReservedByUser(loginUser, gettedBook)) {
			// 본인이 이미 예약한 도서 -> 예약 취소
			bookStatus = 1;
		} else if (rentService.isRentedByUser(loginUser, gettedBook)) {
			// 본인이 이미 대출한 도서 -> 반납하기
			bookStatus = 2;
		} else if (rentService.isRentedBySomeone(gettedBook)) {
			// 본인이 예약하지 않았고 대출도 하지 않았으나 다른 사람이 대출중 -> 예약하기
			bookStatus = 3;
		} else {
			// 본인이 예약하지 않았고 대출도 하지 않았는데 다른 사람도 대출중이 아님 -> 대출하기
			bookStatus = 4;
		}

		System.out.println("bookStatus ----- " + bookStatus);
		model.addAttribute("bookStatus", bookStatus);
		
		//관심도서
		Interested_book interestedBook = interestedBookService.getInterestedBook(gettedBook, loginUser);
		model.addAttribute("interestedBook", interestedBook);
		
		//총 관심도서 수
		int interestCount = interestedBookService.getInterestList(gettedBook).size();
		model.addAttribute("interestCount", interestCount);
		System.out.println(interestCount);
		
		//bookNum에 따른 책 리뷰 불러오기
		List<Book_review> reviewList = reviewService.getReviewList(gettedBook);
		session.setAttribute("reviewList", reviewList);
		return "book/getBook";
	}

	// 책 리뷰 등록
	@PostMapping("/review/insertReview")
	public @ResponseBody ResponseDTO<?> insertReview(@RequestBody Book_review bookReview, HttpSession session) {
		System.out.println("insertReview 컨트롤러");
		System.out.println(bookReview.toString());
		
		User loginUser = (User) session.getAttribute("loginUser");
		Book gettedBook = (Book) session.getAttribute("gettedBook");
		
		List<Rent> rentList = rentService.haveRented(gettedBook, loginUser);
		System.out.println(rentList.toString());
		
		if(rentList.isEmpty()) {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(),"도서 대출 내역이 있어야 후기를 작성할 수 있습니다");
		}else {
			bookReview.setUser(loginUser);
			bookReview.setBook(gettedBook);
			System.out.println("review : " + bookReview.toString());

			reviewService.insertReview(bookReview);
			return new ResponseDTO<>(HttpStatus.OK.value(), "도서 후기 컨트롤러 완료222");
		}
	}

	@GetMapping("/public/book/view/getBookList")
	public String getBookList(@RequestParam(required = false) String category, @RequestParam(required = false) String bookTitle, Model model, HttpSession session, @PageableDefault(size=5,sort="bookNum",direction = Sort.Direction.DESC)Pageable pageable) {
		//List<Book> bookList = null;
		Page<Book> bookList = null;
		
		if(category == null && bookTitle == null) {
			bookList = bookService.getBookList(pageable);
			//System.out.println(bookList.size());
		}else if(category.equals("전체") && bookTitle != null) {
			bookList = bookService.searchBookByTitle(bookTitle,pageable);
			//System.out.println(bookList.size());
		}else if(!category.equals("전체") && bookTitle == null) {
			bookList = bookService.searchBookByCategory(category,pageable);
			//System.out.println(bookList.size());
		}else if(!category.equals("전체") && bookTitle != null) {
			bookList = bookService.searchBookList(category, bookTitle,pageable);
			//System.out.println(bookList.size());
		}
			
		model.addAttribute("bookList", bookList);
		
		int nowPage = bookList.getPageable().getPageNumber()+1; //0부터 시작
		int startPage = 1;
		int endPage = bookList.getTotalPages();
		
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		System.out.println(nowPage);
		System.out.println(startPage);
		System.out.println(endPage);
		
		
		User loginUser = (User)session.getAttribute("loginUser");
		
		Map<Book, Map<String, Object>> bookStatusMap = new HashMap<>();

	    for (Book book : bookList) {
	        Map<String, Object> statusInfo = new HashMap<>();
	        
	        int listStatus;
	        if (reserveService.isReservedByUser(loginUser, book)) {
	            listStatus = 1; // 내가 예약함->예약취소
	        } else if (rentService.isRentedByUser(loginUser, book)) {
	            listStatus = 2; // 내가 대출함->반납
	        } else if (rentService.isRentedBySomeone(book)) {
	            listStatus = 3; // 누군가 대출함->예약하기
	        } else {
	            listStatus = 4; // 대출하기
	        }
	        statusInfo.put("status", listStatus);
	        
	        boolean interested = interestedBookService.isInterestedByUser(loginUser, book);
	        statusInfo.put("interested", interested);
	        
	        bookStatusMap.put(book, statusInfo);
	    }

	    model.addAttribute("bookStatusMap", bookStatusMap);

	    return "book/bookList";
	}
	
	@PostMapping("/book/addInterest")
	public @ResponseBody ResponseDTO<?> addInterest(@RequestBody Book book, HttpSession session) {
		System.out.println(book.toString());
		User loginUser = (User)session.getAttribute("loginUser");
		Interested_book interestBook = new Interested_book();
		interestBook.setBook(book);
		interestBook.setUser(loginUser);
		
		interestedBookService.updateInterest(interestBook);
		return new ResponseDTO<>(HttpStatus.OK.value(),"관심도서 추가하기");
	}
	
	@DeleteMapping("/book/cancelInterest")
	public @ResponseBody ResponseDTO<?> cancelInterest(@RequestBody Book book) {
		interestedBookService.deleteInterest(book);
		return new ResponseDTO<>(HttpStatus.OK.value(),"관심도서 삭제하기");
	}

	@DeleteMapping("/review/deleteReview/{reviewNum}")
	public @ResponseBody ResponseDTO<?> deleteReview(@PathVariable int reviewNum){
		//System.out.println("북 리뷰!!!!!!!!!!" + bookReview.toString());
		reviewService.deleteReview(reviewNum);
		return new ResponseDTO<>(HttpStatus.OK.value(),"리뷰 삭제하기");
	}
	
}
