package com.dailyquest.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthServiceApplication {

    public static void main(String[] args) {

        // 로컬 환경에서만 .env 파일을 로드할 필요 없이, 환경 변수를 그대로 사용
        System.setProperty("DB_URL", System.getenv("DB_URL"));
        System.setProperty("DB_USERNAME", System.getenv("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", System.getenv("DB_PASSWORD"));
        System.setProperty("NAVER_CLIENT_ID", System.getenv("NAVER_CLIENT_ID"));
        System.setProperty("NAVER_CLIENT_SECRET", System.getenv("NAVER_CLIENT_SECRET"));
        System.setProperty("GOOGLE_CLIENT_ID", System.getenv("GOOGLE_CLIENT_ID"));
        System.setProperty("GOOGLE_CLIENT_SECRET", System.getenv("GOOGLE_CLIENT_SECRET"));
        System.setProperty("JWT_SECRET", System.getenv("JWT_SECRET"));

        SpringApplication.run(AuthServiceApplication.class, args);
    }
}
