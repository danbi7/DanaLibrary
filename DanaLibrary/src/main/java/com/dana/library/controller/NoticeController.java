package com.dana.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NoticeController {
	
	@GetMapping("/view/notice")
    public String showNotice() {
        return "/layout/notice"; 
    }
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	
	

}
