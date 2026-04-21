package com.thinkfree.demowebsocket.controller;

import com.thinkfree.demowebsocket.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "차트 API", description = "차트 생성/변경/삭제, 막대 옵션 변경")
@RestController
@RequestMapping("/api/v1")
public class ChartController {

    @Operation(summary = "차트 생성 (HTTP)", description = "선택된 원으로 차트를 생성한다.")
    @PostMapping("/canvas/chart")
    public ApiResponse<String> createChart(@RequestBody CreateChartRequest request) {
        // 실제 로직은 구현하지 않음 (문서 노출용)
        return ApiResponse.of(ResponseCode.CHART_CREATED);
    }

    @Operation(summary = "차트 옵션 변경 (HTTP)", description = "선택된 차트의 이름/x축/y축을 변경한다.")
    @PatchMapping("/canvas/chart/{id}")
    public void updateChart(@PathVariable String id, @RequestBody UpdateChartRequest request) {
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }

    @Operation(summary = "차트 삭제 (HTTP)", description = "선택된 차트를 삭제한다.")
    @DeleteMapping("/canvas/chart/{id}")
    public void deleteChart(@PathVariable String id) {
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }

    @Operation(summary = "차트 막대 옵션 변경 (HTTP)", description = "선택된 막대의 값/이름/색상을 변경한다.")
    @PatchMapping("/canvas/chart/{chartId}/{barId}")
    public void updateBar(@PathVariable String chartId, @PathVariable String barId, @RequestBody UpdateBarRequest request) {
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }

}
