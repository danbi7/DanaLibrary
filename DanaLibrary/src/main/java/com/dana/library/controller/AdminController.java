package com.dana.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	
		@GetMapping("/admin/view/home")
		public String adminHome() {
			return "admin/admin";
		}
}
