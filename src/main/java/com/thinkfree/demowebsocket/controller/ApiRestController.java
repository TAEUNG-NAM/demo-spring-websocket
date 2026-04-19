package com.thinkfree.demowebsocket.controller;

import com.thinkfree.demowebsocket.dto.ChatMessageRequest;
import com.thinkfree.demowebsocket.dto.CircleDrawRequest;
import com.thinkfree.demowebsocket.dto.ApiResponse;
import com.thinkfree.demowebsocket.dto.ResponseCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "WebSocket Canvas API (문서용)", description = "실제로는 WebSocket(STOMP)으로 동작합니다. 경로: ws://...")
@RestController
public class ApiRestController {

    @GetMapping("/api/v1/canvas")
    public ApiResponse<String> getCanvas() {
        Map<String, String> dummy = new HashMap<>();
        dummy.put("CNV", "DUMMY_CANVAS");
        dummy.put("CNV2", "DUMMY_CANVAS2");
        return ApiResponse.of(ResponseCode.CANVAS_LOADED, dummy.toString());
    }

    @PostMapping("/api/v1/circle")
    public ApiResponse<String> createCircle() {
        Map<String, String> circle = new HashMap<>();
        circle.put("x", "15");
        circle.put("y", "120");
        circle.put("color", "#0000000");
        return ApiResponse.of(ResponseCode.CIRCLE_CREATED, circle.toString());
    }

    @Operation(summary = "원 그리기 (WebSocket)", description = "Destination: /app/canvas/draw")
    @PostMapping("/docs/websocket/canvas/circle")
    public void circleDrawDocs(@RequestBody CircleDrawRequest request) {
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }

    @Operation(summary = "원 삭제 (HTTP)", description = "Destination: /canvas/circle")
    @DeleteMapping("/canvas/circle")
    public void circleDeleteDocs(@RequestBody CircleDrawRequest request) {
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }

    @Operation(summary = "크기 조정, 색상 변경 (WebSocket)", description = "Destination: /app/canvas/draw/option")
    @PostMapping("/docs/websocket/canvas/circle/option")
    public void circleOptionDocs(@RequestBody CircleDrawRequest request) {
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }

    @Operation(summary = "메시지 전송 (WebSocket)", description = "Destination: /app/chat/message <br> Subscribe: /topic/chat")
    @PostMapping("/docs/websocket/chat/message")
    public ChatMessageRequest messageSendDocs(@RequestBody ChatMessageRequest request) {
        return null;
    }

    @Operation(summary = "차트 생성 (HTTP)", description = "Destination: /canvas/chart")
    @PostMapping("/canvas/chart")
    public void chartCreateDocs(@RequestBody CircleDrawRequest request) {
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }

}
