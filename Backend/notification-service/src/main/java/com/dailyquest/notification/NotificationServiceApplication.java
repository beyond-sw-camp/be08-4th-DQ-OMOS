package com.dailyquest.notification;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationServiceApplication {

    public static void main(String[] args) {

        // 로컬 환경에서만 .env 파일 로드
        if (isLocalEnvironment()) {
            Dotenv dotenv = Dotenv.load();
            System.setProperty("DB_URL", dotenv.get("DB_URL"));
            System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
            System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
        }

        SpringApplication.run(NotificationServiceApplication.class, args);

    }

    private static boolean isLocalEnvironment() {
        // 로컬 환경을 판단하는 조건 (예: 특정 환경 변수가 설정되어 있지 않으면 로컬 환경으로 판단)
        return System.getenv("CI") == null;  // GitHub Actions나 CI 시스템에서는 'CI' 환경 변수가 설정됨
    }

}
