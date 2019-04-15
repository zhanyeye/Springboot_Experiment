package com.example.experiment_06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@SpringBootApplication
public class Experiment06Application {

    public static void main(String[] args) {

        SpringApplication.run(Experiment06Application.class, args);
    }
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        //启动方法级校验，在spring容器注入方法校验处理器
        return new MethodValidationPostProcessor();
    }
}
