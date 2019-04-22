package com.example.experiment_07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Experiment07Application {

    public static void main(String[] args) {
        SpringApplication.run(Experiment07Application.class, args);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() { //密码编码组件
        return new BCryptPasswordEncoder();
    }
}
