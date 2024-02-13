package com.dana.library.interceptor;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.dana.library.domain.User;

import com.dana.library.service.NoticeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class Interceptor implements HandlerInterceptor{
	
	@Autowired
	private NoticeService noticeService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		
		String requestURI = request.getRequestURI();
	
		if(!(requestURI.equals("/") || requestURI.equals("")) && loginUser == null) {
			response.sendRedirect("/user/view/login");
		}
		
		noticeService.sendNotice(session);
	
		return true;
	}
}
