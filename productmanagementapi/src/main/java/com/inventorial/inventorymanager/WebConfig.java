package com.inventorial.inventorymanager;

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
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/inventory/v1.0/item/**")
                        .allowedOriginPatterns("*") // Allows all origins
                        .allowedMethods("*") // Allows all HTTP methods (GET, POST, PUT, DELETE, etc.)
                        .allowedHeaders("*") // Allows all headers
                        .allowCredentials(true); // Allows cookies to be sent
            }
        };
    }
}
