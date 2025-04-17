package com.eraky.crudSystemSample.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.*;


@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Order Management API")
                        .version("1.0")
                        .description("API documentation for Order Management System by Abdelrahman Eraky" +
                                "for training on swagger ui"));
    }
}
