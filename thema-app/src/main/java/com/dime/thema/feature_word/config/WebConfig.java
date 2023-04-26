package com.dime.thema.feature_word.config;


import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NotNull CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("${DOMAIN}")
                        .allowedOrigins("${DOMAIN}:${ANGULAR_PORT}")
                        .allowedOrigins("http://oo.3dime.com:4200")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET");
            }
        };
    }
}
