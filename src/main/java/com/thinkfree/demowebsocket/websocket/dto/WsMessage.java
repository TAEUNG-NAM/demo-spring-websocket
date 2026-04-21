package com.thinkfree.demowebsocket.websocket.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WsMessage<T> {
    private WsAction action;
    private T payload;
}