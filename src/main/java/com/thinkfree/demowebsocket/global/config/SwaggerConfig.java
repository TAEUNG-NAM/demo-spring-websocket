package com.thinkfree.demowebsocket.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("사내 백엔드 API 문서")
                .version("v1.0.0")
                .description("서비스 관리용 백엔드 API 명세서입니다.");

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
