package com.dana.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dana.library.domain.Comment;
import com.dana.library.service.CommentService;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@GetMapping("/comment/view/register")
	public String register() {
		return "comment/register";
	}
	
	
	@PostMapping("/comment/register")	
	public Comment registerComment(@RequestBody Comment comment) {
		return commentService.registerComment(comment);
	}
//	
//	
//	@PutMapping
//	public
//	
//	@DeleteMapping
//	public

}
