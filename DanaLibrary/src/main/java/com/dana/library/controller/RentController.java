package com.dana.library.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dana.library.domain.Book;
import com.dana.library.domain.Rent;
import com.dana.library.domain.Status;
import com.dana.library.domain.User;
import com.dana.library.dto.ResponseDTO;
import com.dana.library.service.BookService;
import com.dana.library.service.RentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class RentController {
	
	@Autowired
	private RentService rentService;
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/rent/rentBook/{bookNum}")
	public @ResponseBody ResponseDTO<?> rentBook(@PathVariable int bookNum, HttpSession session) {

		User loginUser = (User) session.getAttribute("loginUser");

		List<Rent> gettedList = rentService.getRentList(loginUser);
		// System.out.println(rentList.toString());

		List<Rent> rentList = new ArrayList<Rent>();

		for (Rent rent : gettedList) {
			if (rent.getRentStatus() == Status.ACTIVE) {
				rentList.add(rent);
			}
		}

		int renting = rentList.size();
		System.out.println("rentList size : " + renting);

		if (renting >= 5) { // size는 0부터 시작하니깐
			System.out.println("대출도서가 5권을 초과함");
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "대출도서가 5권을 초과");
		} else {

			Book gettedBook = bookService.getBook(bookNum);
			// System.out.println("gettedBook.toString() : " + gettedBook.toString());

			Rent rent = rentService.getRent(gettedBook);

			if (rent.getRentNum() == 0) { // new Rent()
				rent.setBook(gettedBook);
			}

			Rent newRent = new Rent();
			if (rent.getRentStatus() != Status.ACTIVE) { // 해당도서가 대출중인지?
				newRent.setBook(gettedBook);
				newRent.setUser(loginUser);
				newRent.setRentStatus(Status.ACTIVE);
				LocalDate rentDate = LocalDate.now(); 
				LocalDate dueDate = LocalDate.now().plusDays(7);
				newRent.setRentDate(rentDate);
				newRent.setDueDate(dueDate);
				
				rentService.updateRent(newRent);
				System.out.println("newRent.toString() : " + newRent.toString());
				return new ResponseDTO<>(HttpStatus.OK.value(), "책 빌리기");
			} else {

				return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "책 빌리기 실패");
			}

		}

	}
	
	
	
	
	
}
