package com.github.marciel404.bot.embeds;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;

import static com.github.marciel404.bot.requests.RequestsActions.*;

public class ActionsEmbed {

    public static MessageEmbed kissembed(String author, String receiver){

        return new EmbedBuilder()
                .setDescription(""+ author +" beijou "+ receiver)
                .setImage(kissrequestgif())
                .setColor(Color.BLUE)
                .build();
    }

    public static MessageEmbed hugembed(String author, String receiver){

        return new EmbedBuilder()
                .setDescription(""+ author +" abraçou "+ receiver)
                .setImage(hugrequestgif())
                .setColor(Color.BLUE)
                .build();
    }
}
