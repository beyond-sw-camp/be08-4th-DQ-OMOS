package com.dailyquest.discord.discordbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BotInitializer {

    private final MyListener myListener;

    @Value("${discord.bot.token}")
    private String token;

    public BotInitializer(MyListener commandListener) {
        this.myListener = commandListener;
    }

    @PostConstruct
    public void startBot() throws Exception {
        JDA jda = JDABuilder.createDefault(token)
                .addEventListeners(myListener)
                .build();
        jda.awaitReady();
    }
}
