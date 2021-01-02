package com.springbootecharts.covidmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CovidmapApplication {

    public static void main(String[] args) {
        SpringApplication.run(CovidmapApplication.class, args);
    }

    //将restTemplate工具类加入到spring
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
