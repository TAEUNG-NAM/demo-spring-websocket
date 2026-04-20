package com.thinkfree.demowebsocket.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Schema(description = "유저 ID", example = "user-1")
    private String senderId;
}