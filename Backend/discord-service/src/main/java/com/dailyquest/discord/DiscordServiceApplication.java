package com.dailyquest.discord;

import com.dailyquest.discord.discordbot.MyListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DiscordServiceApplication {

    @Value("${discord.bot.token}")
    private String token;

    public static void main(String[] args) {

        // 로컬 환경에서만 .env 파일 로드
        if (isLocalEnvironment()) {
            Dotenv dotenv = Dotenv.load();
            System.setProperty("DB_URL", dotenv.get("DISCORD_TOKEN"));
        }

        SpringApplication.run(DiscordServiceApplication.class, args);
    }

    private static boolean isLocalEnvironment() {
        // 로컬 환경을 판단하는 조건 (예: 특정 환경 변수가 설정되어 있지 않으면 로컬 환경으로 판단)
        return System.getenv("CI") == null;  // GitHub Actions나 CI 시스템에서는 'CI' 환경 변수가 설정됨
    }


    @Bean
    public CommandLineRunner run() {
        return args -> {
            JDA jda = JDABuilder.createDefault(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT)
                    .addEventListeners(new MyListener())
                    .build();
        };
    }
}
