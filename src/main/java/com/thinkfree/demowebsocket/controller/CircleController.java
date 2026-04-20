package com.thinkfree.demowebsocket.controller;

import com.thinkfree.demowebsocket.dto.CircleDrawRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ChartController {

    @Operation(summary = "차트 생성 (HTTP)", description = "선택된 원으로 차트를 생성한다.")
    @PostMapping("/canvas/chart")
    public void createChart(@RequestBody CircleDrawRequest request) {
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }

    @Operation(summary = "차트 삭제 (HTTP)", description = "선택된 차트를 삭제한다.")
    @DeleteMapping("/canvas/chart")
    public void deleteChart(@RequestBody CircleDrawRequest request) {
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }

    @Operation(summary = "차트 이름 변경 (HTTP)", description = "선택된 차트의 이름을 변경한다.")
    @PostMapping("/canvas/chart")
    public void updateChartName(@RequestBody CircleDrawRequest request) {
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }

    @Operation(summary = "차트 막대 값 변경 (HTTP)", description = "선택된 차트의 막대 바 값을 변경한다.")
    @PostMapping("/canvas/chart")
    public void updateChartBarValue(@RequestBody CircleDrawRequest request) {
        // 실제 로직은 구현하지 않음 (문서 노출용)
    }
}
