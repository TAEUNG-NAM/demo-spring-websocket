package com.thinkfree.demowebsocket.circle.dto;

import com.thinkfree.demowebsocket.circle.domain.Circle;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Schema(description = "원 생성 요청")
public class CreateCircleRequest {

    @Schema(description = "X좌표", example = "34.5")
    @NotNull
    private Double x;

    @Schema(description = "Y좌표", example = "-77")
    @NotNull
    private Double y;


    public Circle toEntity() {
        return Circle.builder()
                .x(this.x)
                .y(this.y)
                .createdAt(new Date().getTime())
                .build();
    }
}