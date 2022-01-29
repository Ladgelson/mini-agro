package com.mini.agro.backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Mini-farm management",
                version = "1.0",
                termsOfService = "Terms of service",
                contact = @Contact(
                        name = "Micaias Ladgelson",
                        email = "micaiasladgelsondasilva@gmail.com"
                )
        )
)
public class OpenApiConfig {
}
