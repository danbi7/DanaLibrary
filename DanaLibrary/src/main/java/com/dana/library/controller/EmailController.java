//package com.dana.library.controller;
//
//import java.util.Random;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.dana.library.service.EmailService;
//
//@Controller
//@RequestMapping("/email")
//public class EmailController {
//
//    @Autowired
//    private EmailService emailService;
//
//    @GetMapping("/send")
//    @ResponseBody public String sendEmail(@RequestParam String email) {
//        String to = email;
//        String subject = "DANA 도서관 인증번호 전송";
//        Random random = new Random();
//        int checkNum = random.nextInt(888888) + 111111;
//        String body = String.valueOf(checkNum);
//
//        emailService.sendEmail(to, subject, body);
//
//        return "Email sent successfully!";
//    }
//}