package com.mktplace;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mktplace"})
@EnableR2dbcRepositories
@OpenAPIDefinition
public class MktplaceApp {
    public static void main(String[] args) {
        SpringApplication.run(MktplaceApp.class, args);
    }
}
