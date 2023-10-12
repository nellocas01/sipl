package com.example.presentation.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info =
@io.swagger.v3.oas.annotations.info.Info(title = "Core APIs",
        version = "2.0", description = "Core Service APIs Information"
))
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("Demo Service APIs Information"));
    }

}
