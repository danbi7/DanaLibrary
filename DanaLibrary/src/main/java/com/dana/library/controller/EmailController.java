package com.dana.library.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dana.library.service.EmailService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send/email")
    @ResponseBody public void sendEmail(@RequestParam String email ,HttpSession session) {
    	System.out.println("이메일 전송" + email);
        String to = email;
        String subject = "DANA 도서관 인증번호 전송";
        Random random = new Random();
        int checkNum = random.nextInt(888888) + 111111;
        
       session.setAttribute("checkNum", String.valueOf(checkNum));
        
        String body = "다음 6자리 코드를 입력해서 본인 인증을 완료해주세요. \n\n"  + String.valueOf(checkNum);
        emailService.sendEmail(to, subject, body);
    }
}