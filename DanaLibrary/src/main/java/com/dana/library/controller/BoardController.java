package com.dana.library.controller.advice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	@GetMapping("/board/view/insertBoard")
	public String insertBoard() {
		return "board/insertBoard";
	}

}
