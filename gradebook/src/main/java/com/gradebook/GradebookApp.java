package com.gradebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.gradebook.model")
@EnableJpaRepositories("com.gradebook.repository")
public class GradebookApp {
    public static void main(String[] args) {
        SpringApplication.run(GradebookApp.class, args);
    }
}
