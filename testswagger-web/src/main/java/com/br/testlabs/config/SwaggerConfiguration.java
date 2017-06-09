package com.br.testlabs.config;

import static springfox.documentation.spi.DocumentationType.SWAGGER_2;
import static springfox.documentation.swagger.web.UiConfiguration.DEFAULT;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
       
        StopWatch watch = new StopWatch();
        watch.start();
        // @formatter:off
        Docket docket= new Docket(SWAGGER_2)
          .apiInfo(apiInfo())
          .genericModelSubstitutes(ResponseEntity.class)
          .select()
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())
          .build();
        // @formatter:on
        watch.stop();
        return docket;
    }

    @Bean
    public UiConfiguration uiConfig() {
        return DEFAULT;
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        .title("Test Swagger API")
        .description("API para teste do swagger")
        .termsOfServiceUrl("")
        .contact(contact())
        .license("")
        .licenseUrl("")
        .version("")
        .build();
    }

    @Bean
    public Contact contact() {
        return new Contact("TestLabs", "","");
    }
}
