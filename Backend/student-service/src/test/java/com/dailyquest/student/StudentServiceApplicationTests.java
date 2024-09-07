package com.dailyquest.student;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentServiceApplicationTests {

    @Test
    void contextLoads() {
        // 테스트 전에 환경 변수를 설정합니다.
        System.setProperty("DB_URL", "jdbc:mariadb://omos-db.c9i2aecyi0tb.ap-northeast-2.rds.amazonaws.com:3306/testdb");
        System.setProperty("DB_USERNAME", "beyond");
        System.setProperty("DB_PASSWORD", "beyond");
    }

}
