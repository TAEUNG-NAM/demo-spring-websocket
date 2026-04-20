package com.thinkfree.demowebsocket.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CursorMoveRequest {
    private String senderId;  // 커서ID
    private Double x;         // X 좌표
    private Double y;         // Y 좌표
    private String color;     // 커서 색상
}
