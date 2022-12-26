package com.github.marciel404.bot.embeds;

import java.awt.*;
import java.util.Objects;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import org.jetbrains.annotations.NotNull;

import static com.github.marciel404.bot.requests.RequestsActions.*;

public class ActionsEmbed {

    @NotNull
    public static MessageEmbed kissEmbed(String author, String receiver){

        MessageEmbed embed;

        if (Objects.equals(author, receiver)){

            embed = new EmbedBuilder()
                    .setDescription(""+ author +" beijou.. a si mesmo???")
                    .setImage(kissRequestGif())
                    .setColor(Color.BLUE)
                    .build();
        }else {
            embed = new EmbedBuilder()
                    .setDescription(""+ author +" beijou "+ receiver)
                    .setImage(kissRequestGif())
                    .setColor(Color.BLUE)
                    .build();
        }

        return embed;
    }

    @NotNull
    public static MessageEmbed hugEmbed(String author, String receiver){

        return new EmbedBuilder()
                .setDescription(""+ author +" abraçou "+ receiver)
                .setImage(hugRequestGif())
                .setColor(Color.BLUE)
                .build();
    }

    @NotNull
    public static MessageEmbed punchEmbed(String author, String receiver){

        return new EmbedBuilder()
                .setDescription(""+ author +" socou "+ receiver)
                .setImage(punchRequestGif())
                .setColor(Color.BLUE)
                .build();
    }

    @NotNull
    public static MessageEmbed slapEmbed(String author, String receiver){

        return new EmbedBuilder()
                .setDescription(""+ author +" estapeou "+ receiver)
                .setImage(slapRequestGif())
                .setColor(Color.BLUE)
                .build();
    }

}
