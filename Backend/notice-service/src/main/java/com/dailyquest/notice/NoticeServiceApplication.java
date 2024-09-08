package com.dailyquest.notice;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NoticeServiceApplication {

    public static void main(String[] args) {

        // 로컬 환경에서만 .env 파일을 로드할 필요 없이, 환경 변수를 그대로 사용
        System.setProperty("DB_URL", System.getenv("DB_URL"));
        System.setProperty("DB_USERNAME", System.getenv("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", System.getenv("DB_PASSWORD"));

        SpringApplication.run(NoticeServiceApplication.class, args);
    }

}
