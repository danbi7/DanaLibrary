package com.dana.library.controller;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/sse")
@Slf4j
public class SseController {

    public static Map<String, SseEmitter> sseEmitters = new ConcurrentHashMap<>();

    @GetMapping(value = "", consumes = MediaType.ALL_VALUE)
    public SseEmitter streamSseMvc(@RequestParam String userid) {
        log.info("userid = {}", userid);

        // 현재 클라이언트를 위한 SseEmitter 생성
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
        try {
            // 연결!!
            emitter.send(SseEmitter.event().name("connect"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // userId를 key값으로 해서 SseEmitter를 저장
        sseEmitters.put(userid, emitter);

        emitter.onCompletion(() -> sseEmitters.remove(userid));
        emitter.onTimeout(() -> sseEmitters.remove(userid));
        emitter.onError((e) -> sseEmitters.remove(userid));

        return emitter;
    }
}