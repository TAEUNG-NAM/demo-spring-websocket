package com.thinkfree.demowebsocket.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CircleDrawRequest {

    private Double centerX;
    private Double centerY;
    private Double radius;

    private String strokeColor;   // 선 색상 (예: "#FF0000")
    private String fillColor;     // 채우기 색상 (예: "transparent" 또는 "#00FF00")

    private String senderId;      // 도형을 그린 사용자 ID
}