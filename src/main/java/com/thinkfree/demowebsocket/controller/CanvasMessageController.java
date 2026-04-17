package com.thinkfree.demowebsocket.controller;

import com.thinkfree.demowebsocket.dto.ChatMessageRequest;
import com.thinkfree.demowebsocket.dto.CircleDrawRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CanvasMessageController {

    private final SimpMessagingTemplate template;

    @MessageMapping("/canvas/draw")
    public void circleDraw(CircleDrawRequest request) {

    }

    @MessageMapping("/chat/message")
    @SendTo("/topic/canvas")
    public ChatMessageRequest messageSend(@RequestBody ChatMessageRequest request) {
        log.info(request.getContent());
        template.convertAndSend(request.getContent());
        return request;
    }
}
