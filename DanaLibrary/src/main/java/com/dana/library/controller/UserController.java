package com.dana.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dana.library.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

}
