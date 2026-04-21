package com.thinkfree.demowebsocket.chart.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;

@Schema(description = "막대 변경 요청")
public class UpdateBarRequest {

    @Schema(description = "라벨", example = "키친준")
    private String label;

    @Positive
    private Double value;

    @Schema(description = "바 색상", example = "#00FF00")
    private String color;

}
