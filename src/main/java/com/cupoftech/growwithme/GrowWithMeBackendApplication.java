package com.cupoftech.growwithme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GrowWithMeBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrowWithMeBackendApplication.class, args);
    }

}
