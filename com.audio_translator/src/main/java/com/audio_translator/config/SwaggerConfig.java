package com.audio_translator.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.audio_translator"))
                .paths(PathSelectors.any())
                .build().apiInfo(metaInfo());

    }
    private ApiInfo metaInfo() {

        ApiInfo apiInfo=new ApiInfo("Audio translation API",
                "API methods", "0.1",
                "Terms of Service",
                new Contact("Audio translation","---","xxu9401@gmail.com"),
                "MIT", "", Collections.EMPTY_LIST);

        return apiInfo;
    }
}
//http://localhost:8080/swagger-ui.html

