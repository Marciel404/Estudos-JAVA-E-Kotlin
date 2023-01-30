package com.github.marciel404.bot.events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Message extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent message){

        if (!message.isFromGuild())return;
        if (message.getAuthor().isBot()) return;

        switch (message.getMessage().getContentDisplay().toLowerCase()){

            case "macaco", "seu preto" -> {
                message.getMessage().delete().queue();
                message.getMessage().getChannel().sendMessage("Que isso menino calme").queue();
            }

        }
    }
}