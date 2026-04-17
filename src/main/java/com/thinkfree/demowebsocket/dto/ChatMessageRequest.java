package com.thinkfree.demowebsocket.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatMessageRequest {
    private String content;
    private String sender;

}
