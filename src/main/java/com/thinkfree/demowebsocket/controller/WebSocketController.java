package com.thinkfree.demowebsocket.controller;

import com.thinkfree.demowebsocket.dto.ChatMessageRequest;
import com.thinkfree.demowebsocket.dto.UpdateCircleRequest;
import com.thinkfree.demowebsocket.dto.CursorMoveMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class WebSocketController {

    private final SimpMessagingTemplate template;

    @GetMapping("/")
    public String index() {
        return "WebSocketChatTest";
    }

    @MessageMapping("/canvas/draw")
    @SendTo("/topic/canvas/draw")
    public void circleDraw(UpdateCircleRequest request) {

    }

    @MessageMapping("/chat/message")
    @SendTo("/topic/chat")
    public ChatMessageRequest messageSend(@RequestBody ChatMessageRequest request) {
        log.info("Received message : {}", request);
        return request;
    }

    /**
     * 실시간 커서 공유
     * @param request
     * @return
     */
    @MessageMapping("/canvas/cursor")
    @SendTo("/topic/canvas/cursor")
    public CursorMoveMessage moveCursor(CursorMoveMessage request) {
        // 커서 이동은 DB에 저장할 필요 없이 즉시 브로드캐스팅만 수행
        return request;
    }

}
