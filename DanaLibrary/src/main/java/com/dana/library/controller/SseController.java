package com.dana.library.controller;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.dana.library.domain.Notice;
import com.dana.library.domain.User;
import com.dana.library.service.NoticeService;

import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/sse")
public class SseController {

    private final Map<Integer, SseEmitter> emitters = new ConcurrentHashMap<>();
    
    @Autowired
    private NoticeService noticeService; 

    @GetMapping("/subscribe")
    public SseEmitter subscribe(HttpSession session) {
    	System.out.println("SSEEMITTER 실행");
        User loginUser = (User) session.getAttribute("loginUser");
        System.out.println("SSE 로그인 회원: " + loginUser);
        if (loginUser != null) {
            SseEmitter emitter = new SseEmitter();
            emitters.put(loginUser.getUserNum(), emitter);
            emitter.onCompletion(() -> emitters.remove(loginUser.getUserNum()));
            emitter.onTimeout(() -> emitters.remove(loginUser.getUserNum()));
            return emitter;
        } else {
            // 로그인되지 않은 사용자에 대한 처리
            return null;
        }
    }

    @GetMapping("/sendNotice")
    public void sendNotice(HttpSession session) {
    	System.out.println("sendNotice 실행");
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser != null) {
            // 알림 테이블에서 해당 회원의 알림을 가져옴
            Notice notice = noticeService.findNotice(loginUser);
            System.out.println("로그인 회원의 notice: " + notice);
            if (notice != null) {
                // 알림이 존재하면 해당 사용자의 SseEmitter로 알림 전송
                SseEmitter emitter = emitters.get(loginUser.getUserNum());
                if (emitter != null) {
                    try {
                        emitter.send(SseEmitter.event().name("notice").data(notice.getContent()));
                    } catch (IOException e) {
                        // Handle exception
                    }
                }
            }
        }
    }
}