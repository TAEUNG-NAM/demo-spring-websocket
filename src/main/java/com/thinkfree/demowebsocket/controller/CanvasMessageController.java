package com.thinkfree.demowebsocket.controller;

import com.thinkfree.demowebsocket.dto.ChatMessageRequest;
import com.thinkfree.demowebsocket.dto.CircleDrawRequest;
import com.thinkfree.demowebsocket.dto.CursorMoveRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CanvasMessageController {

    private final SimpMessagingTemplate template;

    @GetMapping("/")
    public String index() {
        return "WebSocketChatTest";
    }

    @MessageMapping("/canvas/draw")
    public void circleDraw(CircleDrawRequest request) {

    }

    @MessageMapping("/chat/message")
    @SendTo("/topic/chat")
    public ChatMessageRequest messageSend(@RequestBody ChatMessageRequest request) {
        log.info("Received message : {}", request);
        return request;
    }

    @MessageMapping("/cursor/move")
    @SendTo("/topic/canvas/cursor")
    public CursorMoveRequest moveCursor(CursorMoveRequest request) {
        // 커서 이동은 DB에 저장할 필요 없이 즉시 브로드캐스팅만 수행
        return request;
    }
}
