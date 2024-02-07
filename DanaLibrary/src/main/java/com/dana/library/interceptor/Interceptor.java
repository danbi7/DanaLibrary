//package com.dana.library.interceptor;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.dana.library.domain.User;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//@Component
//public class Interceptor implements HandlerInterceptor{
//	
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
//		HttpSession session = request.getSession();
//		User loginUser = (User) session.getAttribute("loginUser");
//		
//		if(loginUser == null) {
//			response.sendRedirect("/user/view/login");
//		}
//		
//		return true;
//	}
//	
//	 @Override
//	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//	        // After completion of request, do nothing
//	    }
//
//}
