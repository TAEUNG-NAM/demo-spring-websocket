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

    @Builder.Default
    private double size = 10.5;

    @Builder.Default
    private double r = 0.111;

    @Builder.Default
    private double g = 0.222;

    @Builder.Default
    private double b = 0.333;

    @Builder.Default
    private double a = 0.9;

    private Long createdAt;
}
