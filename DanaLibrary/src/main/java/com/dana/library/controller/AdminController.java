package com.dana.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	@GetMapping("/admin/view/home")
	public String adminHome() {
		return "admin/admin";
	}
	
	@GetMapping("/view/admin")
	public String admin() {
		return "admin/admin";
	}

	@GetMapping("/view/myPage")
	public String myPage() {
		return "admin/myPage";
	}
	
	@GetMapping("/admin/view/editMyInfo")
	public String editMyInfo() {
		return "admin/editMyInfo";
	}

}
