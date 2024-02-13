package com.dana.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.dana.library.domain.Notice;
import com.dana.library.domain.Reserved_book;
import com.dana.library.domain.User;
import com.dana.library.dto.ResponseDTO;
import com.dana.library.persistence.UserRepository;
import com.dana.library.service.NoticeService;
import com.dana.library.service.ReserveService;

import jakarta.servlet.http.HttpSession;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;

	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/view/notice")
	public String showNotice(Model model) {
		Reserved_book reserve = (Reserved_book) model.getAttribute("reserve");
		model.addAttribute("reserve", reserve);
		return "layout/notice";
	}

	
	@GetMapping("/notice/getNotice/{userNum}")
	public String getNotice(@PathVariable int userNum, Model model) {
	    User user = userRepository.findById(userNum).orElse(null);

	    if (user != null) {
	        System.out.println("알림 가져올 회원: " + user);
	        // 로그인 회원의 예약 목록 조회
	     
	        Notice notice = noticeService.findNotice(user);
	        model.addAttribute("notice", notice);
	    } 
	    return "layout/notice";
	}
	
	@GetMapping("/notice/deleteNotice")
	public @ResponseBody ResponseDTO<?> deleteNotice(HttpSession session){
		User loginUser = (User) session.getAttribute("loginUser");
		System.out.println("알림 삭제");
		noticeService.deleteNotice(loginUser);	
		return new ResponseDTO<>(HttpStatus.OK.value(), "notice 삭제 완료");
	}
}
