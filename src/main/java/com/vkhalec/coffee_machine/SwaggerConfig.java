package com.vkhalec.coffee_machine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vkhalec.coffee_machine"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("REST-сервис на Spring Boot + PostgreSQL")
                .contact(new Contact("VKhalec", "https://t.me/VKhalec", "Larannrf@gmail.com"))
                .description("Тестовое задание в компанию АИСА ИТ-Сервис")
                .version("1.0")
                .build();
    }
}
