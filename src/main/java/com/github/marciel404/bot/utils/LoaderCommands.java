package com.github.marciel404.bot.utils;

import net.dv8tion.jda.api.interactions.commands.OptionType;

import static com.github.marciel404.bot.utils.loader.*;

public class LoaderCommands {

    public static void load(){
        client.upsertCommand("kiss","Beija Um MEMBRO")
                .setGuildOnly(true)
                .addOption(OptionType.USER, "member", "Mencione o membro",true)
                .queue();
    }
}
