package com.thinkfree.demowebsocket.circle.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@Builder
@Document(collection = "circles")
public class Circle {

    @Id
    private String id;

    private double x;

    private double y;

    private double size;

    private double r;
    private double g;
    private double b;

    private double a;
}
