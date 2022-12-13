package com.github.marciel404.bot.events;

import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Ready extends ListenerAdapter {

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        System.out.println("Eu entei como " + event.getJDA().getSelfUser().getName());
        event.getJDA().setAutoReconnect(true);
    }
}
