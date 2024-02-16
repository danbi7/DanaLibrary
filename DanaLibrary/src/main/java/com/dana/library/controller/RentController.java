package com.dana.library.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dana.library.domain.Book;
import com.dana.library.domain.Rent;
import com.dana.library.domain.Reserved_book;
import com.dana.library.domain.Status;
import com.dana.library.domain.User;
import com.dana.library.dto.ResponseDTO;
import com.dana.library.service.BookService;
import com.dana.library.service.NoticeService;
import com.dana.library.service.RentService;
import com.dana.library.service.ReserveService;

import jakarta.servlet.http.HttpSession;

@Controller
public class RentController {

	@Autowired
	private RentService rentService;

	@Autowired
	private BookService bookService;
	
	@Autowired
	private ReserveService reserveService;
	
	@Autowired
	private NoticeService noticeService;

	@PostMapping("/rent/rentBook/{bookNum}")
	public @ResponseBody ResponseDTO<?> rentBook(@PathVariable int bookNum, HttpSession session) {
		System.out.println("rentBook 실행");
		User loginUser = (User) session.getAttribute("loginUser");

		// 로그인 유저의 active인 list
		List<Rent> rentList = rentService.rentedByLoginUser(loginUser);

		int renting = rentList.size();

		if (renting >= 5) { // size는 0부터 시작하니깐
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "도서 대출은 다섯권까지만 가능합니다.");
		} else {

			Book gettedBook = bookService.getBook(bookNum);
			Rent rent = new Rent();

			rent.setBook(gettedBook);
			rent.setUser(loginUser);
			rent.setRentStatus(Status.ACTIVE);
			LocalDate dueDate = LocalDate.now().plusDays(7);
			rent.setDueDate(dueDate);
			rentService.updateRent(rent);
			return new ResponseDTO<>(HttpStatus.OK.value(), "도서 대출 완료");
		}

	}
	
	//세션과 bookNum으로 반납하기
	@PutMapping("/rent/returnBook/{bookNum}")
	public @ResponseBody ResponseDTO<?> returnBook(@PathVariable int bookNum, HttpSession session) {
		User loginUser = (User) session.getAttribute("loginUser");

		Book gettedBook = bookService.getBook(bookNum);
		
		Rent rent = rentService.isRentedByLoginUser(loginUser, gettedBook);
		
		if(rent.getRentNum()!=0) {
			rent.setDueDate(LocalDate.now());
			rent.setRentStatus(Status.INACTIVE);
			rentService.returnBook(rent);
			Reserved_book reserve = reserveService.rentedBookInReservedBook(rent.getBook());
			if(reserve!=null) {
				noticeService.addNotice(reserve);
			}
			
			return new ResponseDTO<>(HttpStatus.OK.value(), "도서 반납 완료");
		}else {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "도서 반납 실패");
		}
	}
	
	//rentNum으로 반납시키기
	@PutMapping("/rent/returnRent/{rentNum}")
	public @ResponseBody ResponseDTO<?> returnRent(@PathVariable int rentNum){
		Rent rent = rentService.getRent(rentNum);
		if(rent.getRentStatus().equals(Status.INACTIVE)) {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "이미 반납된 도서입니다.");
		}
		rent.setRentStatus(Status.INACTIVE);
		rentService.returnBook(rent);
		return new ResponseDTO<>(HttpStatus.OK.value(), "반납 완료되었습니다.");
	}
	
	//대출 연장
	@PutMapping("/rent/renewalRent/{rentNum}")
	public @ResponseBody ResponseDTO<?> renewalRent(@PathVariable int rentNum){
		Rent rent = rentService.getRent(rentNum);
		if(rent.getRentStatus().equals(Status.INACTIVE) || rent.getRenewalStatus().equals(Status.ACTIVE)) {
			return new ResponseDTO<>(HttpStatus.BAD_GATEWAY.value(), "대출 연장이 불가능합니다.");
		}
		
		//예약테이블에서 검사
		Reserved_book reserve = reserveService.getReserve(rent.getBook().getBookNum());
		System.out.println("예약: " +reserve);
		if(reserve==null) {
			//3일 연장
			rentService.renewalRent(rent);
			return new ResponseDTO<>(HttpStatus.OK.value(),"대출 연장이 완료되었습니다.");
		}
		else {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "이미 예약된 도서입니다.");
		}
	}

}