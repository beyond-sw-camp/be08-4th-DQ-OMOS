package com.dailyquest.discord.discordbot;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class MyListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();

        if (message.equals("안녕?")) {
            event.getChannel().sendMessage("반가워 ㅋㅋ").queue();
        }
    }
}
