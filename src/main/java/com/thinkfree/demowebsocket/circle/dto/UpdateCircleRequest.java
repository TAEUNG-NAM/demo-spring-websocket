package com.thinkfree.demowebsocket.circle.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Schema(description = "원 변경 요청")
public class UpdateCircleRequest {

    @Schema(description = "X좌표", example = "34.5")
    private Double centerX;

    @Schema(description = "Y좌표", example = "-77")
    private Double centerY;

    @Schema(description = "반지름", example = "45")
    private Double radius;

    @Schema(description = "색상", example = "#00FF00")
    private String color;

//    @Schema(description = "유저 ID", example = "user-1")
//    private String userId;
}