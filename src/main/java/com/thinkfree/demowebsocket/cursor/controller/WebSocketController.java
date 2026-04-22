package com.thinkfree.demowebsocket.websocket.controller;

import com.thinkfree.demowebsocket.websocket.dto.CircleDrawEvent;
import com.thinkfree.demowebsocket.dto.*;
import com.thinkfree.demowebsocket.websocket.dto.CursorMoveEvent;
import com.thinkfree.demowebsocket.websocket.dto.WsAction;
import com.thinkfree.demowebsocket.websocket.dto.WsMessage;
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
    public WsMessage<CircleDrawEvent> circleDraw(CircleDrawEvent request) {
        return new WsMessage<>(WsAction.CIRCLE_DRAW_START, request);
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
    public WsMessage<CursorMoveEvent> moveCursor(CursorMoveEvent request) {
        // 커서 이동은 DB에 저장할 필요 없이 즉시 브로드캐스팅만 수행
//        log.info("Received message : {}", new WsMessage<>(WsAction.CURSOR_MOVE, request));
        return new WsMessage<>(WsAction.CURSOR_MOVE, request);
    }

}
