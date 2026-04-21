package com.thinkfree.demowebsocket.circle.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CircleResizeEvent {
    private Long circleId;

    private Double startX;
    private Double startY;

    private Double currentX;
    private Double currentY;

    private Double radius;

//    private String action; // RESIZE_START, RESIZE_UPDATE, RESIZE_END
}
