package com.thinkfree.demowebsocket.circle.controller;

import com.thinkfree.demowebsocket.circle.domain.Circle;
import com.thinkfree.demowebsocket.circle.service.CircleService;
import com.thinkfree.demowebsocket.common.dto.ApiResponse;
import com.thinkfree.demowebsocket.circle.dto.CreateCircleRequest;
import com.thinkfree.demowebsocket.common.dto.ApiResponseCode;
import com.thinkfree.demowebsocket.circle.dto.UpdateCircleRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "원 API", description = "원 생성/변경/삭제")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CircleController {

    private final CircleService circleService;

    @Operation(summary = "원 생성 (HTTP)", description = "그려진 원을 생성한다.")
    @PostMapping("/canvas/circles")
    public ApiResponse<Circle> createCircle(@RequestBody @Valid CreateCircleRequest request) {
        Circle circle = circleService.createCircle(request);
        return ApiResponse.of(ApiResponseCode.CIRCLE_CREATED, circle);
    }

    @Operation(summary = "원 조회 (HTTP)", description = "그려진 모든 원을 조회한다.")
    @GetMapping("/canvas/circles")
    public ResponseEntity<List<Circle>> getCircles() {
        List<Circle> circle = circleService.getAllCircles();
        return ResponseEntity.ok(circle);
    }

    @Operation(summary = "원 조회 (HTTP)", description = "그려진 원을 조회한다.")
    @GetMapping("/canvas/circles/{id}")
    public ResponseEntity<Circle> getCircles(@PathVariable String id) {
        Circle circle = circleService.getCircle(id);
        return ResponseEntity.ok(circle);
    }

    @Operation(summary = "원 단건 삭제 (HTTP)", description = "선택된 원 단건을 삭제한다.")
    @DeleteMapping("/canvas/circles/{id}")
    public void deleteCircle(@PathVariable String id) {
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }

    @Operation(summary = "원 다건 삭제 (HTTP)", description = "선택된 원 다건을 삭제한다.")
    @DeleteMapping("/canvas/circles")
    public void deleteCircles(@RequestParam List<String> ids) {
        for (String id : ids) {
            System.out.println(id);
        }
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }

    @Operation(summary = "원 옵션 변경 (HTTP)", description = "선택된 원의 사용여부/크기/색상을 변경한다.")
    @PatchMapping("/canvas/circles/{id}")
    public void updateCircle(@PathVariable String id, @RequestBody UpdateCircleRequest request) {
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }
}
