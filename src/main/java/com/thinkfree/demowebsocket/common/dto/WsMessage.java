package com.thinkfree.demowebsocket.common.dto;

import com.thinkfree.demowebsocket.cursor.dto.WsAction;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WsMessage<T> {
    private WsAction action;
    private T payload;
}