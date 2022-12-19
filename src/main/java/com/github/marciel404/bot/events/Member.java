package com.github.marciel404.bot.events;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.GuildBanEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import com.github.marciel404.bot.db.Moderation;

public class Member extends ListenerAdapter {

    @Override
    public void onGuildBan(GuildBanEvent event) {
        User user = event.getJDA().getUserById(event.getUser().getId());
        if(user == null) return;
        if (Moderation.verify(user.getId()) > 0){
            System.out.println(11);
        }
    }
}
