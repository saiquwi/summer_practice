package com.example.pract.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.example.pract")
@EnableAspectJAutoProxy
public class ApplicationConfig {
    // Другая конфигурация Spring-бинов
}
