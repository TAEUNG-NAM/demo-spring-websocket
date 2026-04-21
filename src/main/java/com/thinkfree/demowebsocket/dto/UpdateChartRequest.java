package com.thinkfree.demowebsocket.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;

@Schema(description = "차트 변경 요청")
public class UpdateChartRequest {

    @Size(max = 100)
    @Schema(description = "차트 이름", example = "판교 맛집 순위")
    private String name;

    @Schema(description = "X축 이름", example = "식당명")
    private String xAxisTitle;

    @Schema(description = "Y축 이름", example = "점수")
    private String yAxisTitle;
}
