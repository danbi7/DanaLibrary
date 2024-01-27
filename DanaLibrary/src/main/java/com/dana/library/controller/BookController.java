package com.dana.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
	
	@GetMapping("/book/view/getBookList")
	public String getBookList() {
		return "book/bookList";
	}

}
