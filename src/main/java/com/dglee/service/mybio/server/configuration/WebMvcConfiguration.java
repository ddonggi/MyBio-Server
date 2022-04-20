package com.dglee.service.mybio.server.configuration;
/*
 * Created by 이동기 on 2022-03-28
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
//                .allowedOrigins("https://apple.o2o.kr")
                .allowedHeaders("Access-Control-Allow-Origin","*")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
