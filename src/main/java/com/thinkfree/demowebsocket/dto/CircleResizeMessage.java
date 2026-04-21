package com.thinkfree.demowebsocket.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CircleResizeMessage {
    private Long circleId;

    private Integer centerX;
    private Integer centerY;
    private Integer radius;

    private String action; // RESIZE_START, RESIZE_UPDATE, RESIZE_END
}
