package com.dime.thema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.dime.thema.entity")
@EnableJpaRepositories("com.dime.thema.repository")
public class ThemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThemaApplication.class, args);
    }
}