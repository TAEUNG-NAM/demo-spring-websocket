package com.thinkfree.demowebsocket.circle.dto;

import com.thinkfree.demowebsocket.circle.domain.Circle;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Schema(description = "원 생성 요청")
public class CreateCircleRequest {

    @Schema(description = "X좌표", example = "34.5")
    @NotBlank
    private Double centerX;

    @Schema(description = "Y좌표", example = "-77")
    @NotBlank
    private Double centerY;

    @Schema(description = "반지름", example = "45")
    @NotBlank
    private Double radius;

    @Schema(description = "색상", example = "#00FF00")
    @NotBlank
    private String color;


    public Circle toEntity() {
        return Circle.builder()
                .x(this.centerX)
                .y(this.centerY)
                .radius(this.radius)
                .color(this.color)
                .build();
    }
}