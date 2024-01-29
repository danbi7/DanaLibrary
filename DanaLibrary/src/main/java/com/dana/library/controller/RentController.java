package com.dana.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		
		User loginUser = (User)session.getAttribute("loginUser");
		
		List<Rent> rentList = rentService.getRentList(loginUser);
		System.out.println(rentList.toString());
		
		int renting = rentList.size();
		System.out.println(renting);
		
		
		if(renting>5) {
			System.out.println("대출도서가 5권을 초과함");
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(),"대출도서가 5권을 초과");
		}else { 
		
			Book gettedBook = bookService.getBook(bookNum);
			//System.out.println(gettedBook.toString());
		
			Rent rent = rentService.getRent(gettedBook);
		
			if(rent.getRentStatus()!=Status.INACTIVE) { //해당도서가 대출중인지?
				rent.setUser(loginUser);
				rent.setRentStatus(Status.INACTIVE);
				rentService.updateRent(rent);
				System.out.println(rent.toString());
				//return new ResponseDTO<>(HttpStatus.OK.value(),"책 빌리기");
			}//else {
				//예약중인지?
			//}
			return new ResponseDTO<>(HttpStatus.OK.value(),"책 빌리기");
		
		}	
		//return new ResponseDTO<>(HttpStatus.OK.value(),"책 빌리기");
	}
	
	@DeleteMapping("/rent/returnBook/{bookNum}")
	public @ResponseBody ResponseDTO<?> returnBook(@PathVariable int bookNum) {
		Book gettedBook = bookService.getBook(bookNum);
		
		rentService.deleteRent(gettedBook);
		
		return new ResponseDTO<>(HttpStatus.OK.value(),"책 반납하기");
	}
	
	
}
