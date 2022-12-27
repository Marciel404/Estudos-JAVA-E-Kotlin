package com.github.marciel404.bot.embeds;

import java.awt.*;
import java.util.Objects;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import org.jetbrains.annotations.NotNull;
import static com.github.marciel404.bot.requests.RequestsActions.*;

public class ActionsEmbed {

    @NotNull
    public static MessageEmbed kissEmbed(String author, String receiver, String selfBotMention) {

        MessageEmbed embed;

        if (author.equals(receiver)) {

            embed = new EmbedBuilder()
                    .setDescription(String.format("%s beijou... a si mesmo???", author))
                    .setImage(kissRequestGif())
                    .setColor(Color.BLUE)
                    .build();

        } else if (receiver.equals(selfBotMention)) {

            embed = new EmbedBuilder()
                    .setTitle("Acho melhor sermos só amigos")
                    .setDescription(
                            String.format(
                                    "%s abraçou %s",
                                    selfBotMention , author
                            )
                    )
                    .setImage(hugRequestGif())
                    .setColor(Color.BLUE).build();

        }else {
            embed =  new EmbedBuilder()
                    .setDescription(String.format("%s beijou %s2", author , receiver))
                    .setImage(kissRequestGif())
                    .setColor(Color.BLUE)
                    .build();
        }

        return embed;
    }

    @NotNull
    public static MessageEmbed hugEmbed(String author, String receiver, String selfBotMention){

        MessageEmbed embed;

        if (receiver.equals(selfBotMention)){

            embed = new EmbedBuilder()
                    .setDescription(
                            String.format(
                                    "Obrigado pelo abraço %s abraçou %s2",
                                    author , receiver
                            )
                    )
                    .setImage(hugRequestGif())
                    .setColor(Color.BLUE)
                    .build();

        } else if (author.equals(receiver)) {

            embed = new EmbedBuilder()
                    .setTitle("Você está tão solitario assim?\nAqui, deixa eu te abraçar")
                    .setDescription(
                            String.format(
                                    "%s abraçou %s",
                                    selfBotMention , author
                            )
                    )
                    .setImage(hugRequestGif())
                    .setColor(Color.BLUE)
                    .build();

        } else {

            embed = new EmbedBuilder()
                    .setDescription(
                            String.format(
                                    "%s abraçou %s",
                                    author , receiver
                            )
                    )
                    .setImage(hugRequestGif())
                    .setColor(Color.BLUE)
                    .build();

        }

        return embed;
    }

    @NotNull
    public static MessageEmbed punchEmbed(String author, String receiver, String selfBotMention){

        MessageEmbed embed;

        if (author.equals(receiver)){

            embed = new  EmbedBuilder()
                    .setDescription(String.format("%s socou a si mesmo???", author))
                    .setImage(punchRequestGif())
                    .setColor(Color.RED)
                    .build();
        } else if (receiver.equals(selfBotMention)) {

            embed = new EmbedBuilder()
                    .setDescription(String.format("%s socou %s", selfBotMention , author))
                    .setImage(punchRequestGif())
                    .setColor(Color.BLUE)
                    .build();

        } else {
            embed = new EmbedBuilder()
                    .setDescription(String.format("%s socou %s", author , receiver))
                    .setImage(punchRequestGif())
                    .setColor(Color.BLUE)
                    .build();
        }

        return embed;
    }

    @NotNull
    public static MessageEmbed slapEmbed(String author, String receiver, String selfBotMention){

        MessageEmbed embed;

        if (author.equals(receiver)){

            embed = new  EmbedBuilder()
                    .setDescription(String.format("%s estapeou a si mesmo???", author))
                    .setImage(punchRequestGif())
                    .setColor(Color.RED)
                    .build();

        } else if (receiver.equals(selfBotMention)) {

            embed = new  EmbedBuilder()
                    .setDescription(String.format("%s estapeou %s2", selfBotMention , author))
                    .setImage(punchRequestGif())
                    .setColor(Color.RED)
                    .build();

        } else {

            embed = new EmbedBuilder()
                    .setDescription(String.format("%s estapeou %s2", author , receiver))
                    .setImage(slapRequestGif())
                    .setColor(Color.BLUE)
                    .build();
        }

        return embed;
    }

}
