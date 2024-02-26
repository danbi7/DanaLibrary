package com.dana.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dana.library.domain.Reserved_book;
import com.dana.library.domain.User;
import com.dana.library.dto.ResponseDTO;
import com.dana.library.service.BookService;
import com.dana.library.service.ReserveService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReserveController {
	
	@Autowired
	private ReserveService reserveService;
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/reserve/reserveBook/{bookNum}")
	public @ResponseBody ResponseDTO<?> reserveBook(@PathVariable int bookNum, HttpSession session){
		User loginUser = (User)session.getAttribute("loginUser");
		
		if(reserveService.isReserved(loginUser)) {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "이미 예약한 도서가 있습니다.");
		}else {
			Reserved_book reserve = new Reserved_book();
			reserve.setBook(bookService.getBook(bookNum));
			reserve.setUser(loginUser);
			
			reserveService.reserveBook(reserve);
			int turn = reserveService.reserveTurn(bookNum);
			return new ResponseDTO<>(HttpStatus.OK.value(), "도서 예약 완료. " + turn +"번째 예약자 입니다.");
		}
	}
	
	@DeleteMapping("/reserve/cancelReservation/{bookNum}")
	public @ResponseBody ResponseDTO<?> cancelReservation(@PathVariable int bookNum, HttpSession session){
		User loginUser = (User)session.getAttribute("loginUser");
		Reserved_book reserve = new Reserved_book();
		reserve.setBook(bookService.getBook(bookNum));
		reserve.setUser(loginUser);
		System.out.println("예약 취소");
		reserveService.cancelReservation(reserve);
		return new ResponseDTO<>(HttpStatus.OK.value(), "도서 예약 취소");
	}

}
