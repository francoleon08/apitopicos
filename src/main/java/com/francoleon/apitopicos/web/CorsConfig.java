package com.francoleon.apitopicos.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.context.annotation.Bean;
@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*") // Permitir solicitudes desde todos los orígenes
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Permitir los métodos HTTP especificados
                        .allowedHeaders("*"); // Permitir todos los encabezados
            }
        };
    }
}
