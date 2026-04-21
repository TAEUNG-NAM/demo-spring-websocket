package com.thinkfree.demowebsocket.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Schema(description = "차트 생성 요청")
public class CreateChartRequest {

    @Schema(description = "차트 이름", example = "판교 맛집 순위")
    private String name;

    @NotEmpty
    @Schema(description = "데이터", example = "")
    private List<BarCreateRequest> bars;


    @Schema(description = "차트 생성 시 막대 옵션")
    public static class BarCreateRequest {

        @NotBlank
        @Schema(description = "라벨", example = "1월")
        private String label;

        @NotNull
        @Positive
        @Schema(description = "값", example = "55")
        private Double value;

        @Schema(description = "색상", example = "#00FF00")
        private String color;
    }
}