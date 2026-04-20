package com.thinkfree.demowebsocket.dto;

public class UpdateChartRequest {
    public class UpdateBarRequest {

        private String label;

        @Positive
        private Double value;

        private String color;

        // getter, setter
    }
}
