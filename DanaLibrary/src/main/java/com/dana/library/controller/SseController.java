package com.dana.library.controller;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/sse")
public class SseController {

    private final Map<String, SseEmitter> emitters = new ConcurrentHashMap<>();

    @GetMapping("/subscribe")
    public SseEmitter subscribe() {
        SseEmitter emitter = new SseEmitter();
        emitters.put("uniqueUserId", emitter);
        emitter.onCompletion(() -> emitters.remove("uniqueUserId"));
        emitter.onTimeout(() -> emitters.remove("uniqueUserId"));
        return emitter;
    }

    @GetMapping("/sendNotification")
    public void sendNotification() {
        SseEmitter emitter = emitters.get("uniqueUserId");
        if (emitter != null) {
            try {
                emitter.send(SseEmitter.event().name("notification").data("Your notification message"));
            } catch (IOException e) {
                // Handle exception
            }
        }
    }
}