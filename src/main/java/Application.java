package com.pragma.reservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.pragma.reservas.domain", "com.pragma.reservas.infrastructure"})
@EnableJpaRepositories(basePackages = {"com.pragma.reservas.infrastructure.adapters"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}