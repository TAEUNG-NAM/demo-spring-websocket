package com.thinkfree.demowebsocket.controller;

import com.thinkfree.demowebsocket.dto.ChatMessageRequest;
import com.thinkfree.demowebsocket.dto.UpdateCircleRequest;
import com.thinkfree.demowebsocket.dto.CursorMoveRequest;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
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
public class CanvasMessageController {

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

    @MessageMapping("/canvas/cursor")
    @SendTo("/topic/canvas/cursor")
    public CursorMoveRequest moveCursor(CursorMoveRequest request) {
        // 커서 이동은 DB에 저장할 필요 없이 즉시 브로드캐스팅만 수행
        return request;
    }

    @Operation(summary = "원 삭제 (HTTP)", description = "Destination: /canvas/circle")
    @DeleteMapping("/canvas/circle")
    @Hidden
    public void circleDeleteDocs(@RequestBody UpdateCircleRequest request) {
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }

    @Operation(summary = "색상 변경 (HTTP)", description = "Destination: /app/canvas/draw/option")
    @PatchMapping("/canvas/circle")
    @Hidden
    public void circleOptionDocs(@RequestBody UpdateCircleRequest request) {
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }

    @Operation(summary = "차트 생성 (HTTP)", description = "Destination: /canvas/chart")
    @PostMapping("/canvas/chart")
    @Hidden
    public void chartCreateDocs(@RequestBody UpdateCircleRequest request) {
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }
}
