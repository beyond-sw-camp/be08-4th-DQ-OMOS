package com.dailyquest.discord;

import com.dailyquest.discord.discordbot.MyListener;
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
