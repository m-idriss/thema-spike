package com.dime.thema.feature_word.config;


import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(@NotNull CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowedOrigins("//localhost:8080")
                .allowedOrigins("${DOMAIN}:${SPRING_PORT}")
                .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS");
    }
}
