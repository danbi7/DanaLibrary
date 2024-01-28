package com.dana.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("/view/admin")
	public String admin() {
		return "admin/admin";
	}

	@GetMapping("/view/myPage")
	public String myPage() {
		return "admin/myPage";
	}

}
