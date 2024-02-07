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
	
	@Autowired
	private SseController sseController;


	@PostMapping("/rent/rentBook/{bookNum}")
	public @ResponseBody ResponseDTO<?> rentBook(@PathVariable int bookNum, HttpSession session) {

		User loginUser = (User) session.getAttribute("loginUser");

		/*
		 * List<Rent> gettedList = rentService.getRentList(loginUser); //
		 * System.out.println(rentList.toString());
		 * 
		 * List<Rent> rentList = new ArrayList<Rent>();
		 * 
		 * for (Rent rent : gettedList) { if (rent.getRentStatus() == Status.ACTIVE) {
		 * rentList.add(rent); } }
		 */
		// 로그인 유저의 active인 list
		List<Rent> rentList = rentService.rentedByLoginUser(loginUser);

		int renting = rentList.size();
		System.out.println("rentList size : " + renting);

		if (renting >= 5) { // size는 0부터 시작하니깐
			System.out.println("대출도서가 5권을 초과함");
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "대출도서가 5권을 초과");
		} else {

			Book gettedBook = bookService.getBook(bookNum);
			System.out.println("gettedBook.toString() : " + gettedBook.toString());

			Rent rent = new Rent();

			rent.setBook(gettedBook);
			rent.setUser(loginUser);
			rent.setRentStatus(Status.ACTIVE);
			LocalDate rentDate = LocalDate.now();
			LocalDate dueDate = LocalDate.now().plusDays(7);
			rent.setRentDate(rentDate);
			rent.setDueDate(dueDate);
			rentService.updateRent(rent);
			return new ResponseDTO<>(HttpStatus.OK.value(), "책 빌리기");
		}

		// }else {
		// return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "책 빌리기 실패");
		// }
		/*
		 * Rent rent = rentService.getRent(gettedBook);
		 * 
		 * 
		 * Rent newRent = new Rent(); if (rent.getRentStatus() != Status.ACTIVE) { //
		 * 해당도서가 대출중인지? newRent.setBook(gettedBook); newRent.setUser(loginUser);
		 * newRent.setRentStatus(Status.ACTIVE); LocalDate rentDate = LocalDate.now();
		 * LocalDate dueDate = LocalDate.now().plusDays(7);
		 * newRent.setRentDate(rentDate); newRent.setDueDate(dueDate);
		 * 
		 * rentService.updateRent(newRent); System.out.println("newRent.toString() : " +
		 * newRent.toString()); return new ResponseDTO<>(HttpStatus.OK.value(),
		 * "책 빌리기"); } else {
		 * 
		 * return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "책 빌리기 실패"); }
		 */

		// }

	}

	@PutMapping("/rent/returnBook/{bookNum}")
	public @ResponseBody ResponseDTO<?> returnBook(@PathVariable int bookNum, HttpSession session) {
		User loginUser = (User) session.getAttribute("loginUser");

		Book gettedBook = bookService.getBook(bookNum);

		Rent rent = rentService.isRentedByLoginUser(loginUser, gettedBook);

		// Rent rent = rentService.getRent(gettedBook);

		// System.out.println("rent.toString() : " + rent.toString());

		if (rent.getRentNum() != 0) {
			rent.setRentStatus(Status.INACTIVE);
			rentService.updateRent(rent);
			
			//대출 도서중 예약 우선 순위인 정보 조회하기 reserve는 해당 예약
			Reserved_book reserve = reserveService.rentedBookInReservedBook(rent.getBook());
			noticeService.addNotice(reserve);
			sseController.sendNotice(session);
			
			return new ResponseDTO<>(HttpStatus.OK.value(), "  책 반납하기");
		} else {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "책 반납하기 실패");
		}

		/*
		 * if (rent.getRentNum() != 0) { if (rent.getUser().getUserNum() ==
		 * loginUser.getUserNum()) { rent.setRentStatus(Status.INACTIVE);
		 * 
		 * System.out.println(rent.toString());
		 * 
		 * rentService.updateRent(rent); return new ResponseDTO<>(HttpStatus.OK.value(),
		 * "  책 반납하기"); } }
		 * 
		 * return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "책 반납하기 실패");
		 */
	}

}