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
    private double x;

    @Schema(description = "Y좌표", example = "-77")
    @NotBlank
    private double y;

    @Schema(description = "지름", example = "45")
    @NotBlank
    private double size;

    @Schema(description = "색상 R", example = "0.4231234")
    @NotBlank
    private double r;

    @Schema(description = "색상 G", example = "0.1231552")
    @NotBlank
    private double g;

    @Schema(description = "색상 B", example = "0.9374712")
    @NotBlank
    private double b;

    @Schema(description = "투명도", example = "1")
    @NotBlank
    private double a;


    public Circle toEntity() {
        return Circle.builder()
                .x(this.x)
                .y(this.y)
                .size(this.size)
                .r(this.r)
                .g(this.g)
                .b(this.b)
                .a(this.a)
                .build();
    }
}