package com.dailyquest.student;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentServiceApplication {

    public static void main(String[] args) {

        System.setProperty("DB_URL", System.getenv("DB_URL"));
        System.setProperty("DB_USERNAME", System.getenv("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", System.getenv("DB_PASSWORD"));

        SpringApplication.run(StudentServiceApplication.class, args);
    }
}
