package com.example.security.config;

import com.example.security.service.DatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class TestConfig {
    private final DatabaseService databaseService;

    @Bean
    public Boolean initializeDatabase() {
        databaseService.initializeDatabase();
        return true;
    }
}
