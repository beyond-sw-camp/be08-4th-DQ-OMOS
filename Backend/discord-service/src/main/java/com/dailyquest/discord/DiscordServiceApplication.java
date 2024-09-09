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

    public static void main(String[] args) {

        // 로컬 환경에서만 .env 파일을 로드할 필요 없이, 환경 변수를 그대로 사용
        System.setProperty("DB_URL", System.getenv("DB_URL"));
        System.setProperty("DB_USERNAME", System.getenv("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", System.getenv("DB_PASSWORD"));
        System.setProperty("DISCORD_TOKEN", System.getenv("DISCORD_TOKEN"));

        SpringApplication.run(DiscordServiceApplication.class, args);
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
