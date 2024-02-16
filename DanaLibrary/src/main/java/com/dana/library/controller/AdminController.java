package com.dana.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dana.library.domain.Book;
import com.dana.library.domain.Interested_book;
import com.dana.library.domain.Rent;
import com.dana.library.domain.Reserved_book;
import com.dana.library.domain.User;
import com.dana.library.dto.ResponseDTO;
import com.dana.library.service.BookService;
import com.dana.library.service.InterestedBookService;
import com.dana.library.service.RentService;
import com.dana.library.service.ReserveService;
import com.dana.library.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;

	@Autowired
	private RentService rentService;

	@Autowired
	private ReserveService reserveService;
	
	@Autowired
	private InterestedBookService interestedBookService;

	// 관리자페이지 불러오기
	@GetMapping("/view/admin")
	public String admin(Model model,Pageable pageable) {
		List<User> userList = userService.getUserList();

		Page<Book> bookList = bookService.getBookList(pageable);

		List<Rent> rentList = rentService.getRentListDESC();
		model.addAttribute("bookList", bookList);
		model.addAttribute("userList", userList);
		model.addAttribute("rentList", rentList);

		return "admin/admin";
	}

	// 마이페이지
	@GetMapping("/view/myPage")
	public String myPage(HttpSession session, Model model) {
		User loginUser = (User) session.getAttribute("loginUser");
		List<Rent> currentRentList = rentService.rentedByLoginUser(loginUser);
		Reserved_book reserve = reserveService.getReserveByUser(loginUser);
		model.addAttribute("currentRentList", currentRentList);
		model.addAttribute("reserve", reserve);

		List<Rent> pastRentList = rentService.pastRentList(loginUser);
		model.addAttribute("pastRentList", pastRentList);
		
		List<Interested_book> interestedBookList = interestedBookService.getInterestedBookListByUser(loginUser);
		model.addAttribute("interestedBookList", interestedBookList);
		return "admin/myPage";
	}

	// 회원 수정 상세 페이지 불러오기
	@GetMapping("/view/userEdit/{userid}")
	public String openEditUser(@PathVariable String userid, Model model) {
		User user = userService.getUser(userid);
		System.out.println(user.getUsername() + "의 정보 불러오기");
		model.addAttribute("user", user);
		return "admin/userEdit";
	}
	
	// 대출 정보 상세 페이지 불러오기
	@GetMapping("/view/rentEdit/{rentNum}")
	public String openEditRent(@PathVariable int rentNum, Model model) {
		Rent rent = rentService.getRent(rentNum);
		model.addAttribute("rent", rent);
		return "admin/rentEdit";
	}

	// 관리자 회원 수정 기능
	@PutMapping("/admin/editUser")
	public @ResponseBody ResponseDTO<?> editUserAdmin(@RequestBody User user) {
		userService.editUserAdmin(user);
		return new ResponseDTO<>(HttpStatus.OK.value(), "회원 정보 수정 완료");
	}

	// 회원 정보 수정 기능
	@PutMapping("/user/editUser")
	public @ResponseBody ResponseDTO<?> editUser(@RequestBody User user, HttpSession session) {
		userService.editUser(user, session);
		return new ResponseDTO<>(HttpStatus.OK.value(), "회원 정보 수정 완료");
	}
	
	//도서 상세 정보 페이지 불러오기
	@PutMapping("/view/bookEdit{bookNum}")
	public String openEditBook(@PathVariable int bookNum, Model model) {
		Book book = bookService.getBook(bookNum);
		model.addAttribute("book", book);
		return null;
	}

}
