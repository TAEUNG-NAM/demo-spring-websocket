package com.thinkfree.demowebsocket.controller;

import com.thinkfree.demowebsocket.dto.ChatMessageRequest;
import com.thinkfree.demowebsocket.dto.UpdateCircleRequest;
import com.thinkfree.demowebsocket.dto.ApiResponse;
import com.thinkfree.demowebsocket.dto.ResponseCode;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "WebSocket API (문서용)", description = "실제로는 WebSocket(STOMP)으로 동작함. <br> 연결: ws://localhost:8080/ws-stomp")
@RestController
public class ApiRestController {

    @GetMapping("/api/v1/canvas")
    @Hidden
    public ApiResponse<String> getCanvas() {
        Map<String, String> dummy = new HashMap<>();
        dummy.put("CNV", "DUMMY_CANVAS");
        dummy.put("CNV2", "DUMMY_CANVAS2");
        return ApiResponse.of(ResponseCode.CANVAS_LOADED, dummy.toString());
    }

    @PostMapping("/api/v1/circle")
    @Hidden
    public ApiResponse<String> createCircle() {
        Map<String, String> circle = new HashMap<>();
        circle.put("x", "15");
        circle.put("y", "120");
        circle.put("color", "#0000000");
        return ApiResponse.of(ResponseCode.CIRCLE_CREATED, circle.toString());
    }

    @Operation(summary = "웹소켓 연결", description = "Destination: ws://localhost:8080/ws-stomp")
    @PostMapping("/docs/websocket/connect")
    public void webSocketConnectDocs() {
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }

    @Operation(summary = "실시간 커서 공유 (WebSocket)", description = "Destination: /app/canvas/cursor <br> Subscribe: /topic/canvas/cursor")
    @PostMapping("/docs/app/canvas/cursor")
    public void cursorMoveDocs() {
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }

    @Operation(summary = "원 그리기 (WebSocket)", description = "Destination: /app/canvas/draw <br> Subscribe: /topic/canvas")
    @PostMapping("/docs/app/canvas/draw")
    public void circleDrawDocs(@RequestBody UpdateCircleRequest request) {
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }

    @Operation(summary = "원 크기 조정 (WebSocket)", description = "Destination: /app/canvas/resize <br> Subscribe: /topic/canvas")
    @PostMapping("/docs/app/canvas/resize")
    public void circleResizeDocs(@RequestBody UpdateCircleRequest request) {
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }

    @Operation(summary = "원 포커스 (WebSocket)", description = "Destination: /app/canvas/focus <br> Subscribe: /topic/canvas")
    @PostMapping("/docs/app/canvas/focus")
    public void circleFocusDocs(@RequestBody UpdateCircleRequest request) {
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }

    @Operation(summary = "메시지 전송 (WebSocket)", description = "Destination: /app/chat/message <br> Subscribe: /topic/chat")
    @PostMapping("/docs/websocket/chat/message")
    @Hidden
    public ChatMessageRequest messageSendDocs(@RequestBody ChatMessageRequest request) {
        return null;
    }

//    @Operation(summary = "차트 생성 (HTTP)", description = "Destination: /canvas/chart")
//    @PostMapping("/canvas/chart")
//    public void chartCreateDocs(@RequestBody CircleDrawRequest request) {
//        // 실제 로직은 구현하지 않음 (문서 노출용)
//    }

}
