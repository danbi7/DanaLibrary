package com.dana.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeController {
	
	@GetMapping("/view/notice")
    public String showNotice() {
        return "/layout/notice"; 
    }

}