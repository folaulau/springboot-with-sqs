package com.codingwithpro.sqsconsumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RestMVCConfig {

//    @Bean
//    public OpenAPI openProdAPI() {
//        return new OpenAPI().addServersItem(new Server().url("https://prod-api.myincomemanager.com/v1"));
//    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedHeaders("*").allowedMethods("*").allowedOrigins("*");
            }

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                // TODO Auto-generated method stub
                // WebMvcConfigurer.super.addResourceHandlers(registry);

                registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

                registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
            }

        };
    }


}
