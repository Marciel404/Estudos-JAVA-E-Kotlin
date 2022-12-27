package com.github.marciel404.bot.utils

import net.dv8tion.jda.api.interactions.commands.OptionType

fun loadCommands() {
    client.upsertCommand("kiss", "Beija Um Membro")
        .setGuildOnly(true)
        .addOption(OptionType.USER, "member", "Mencione o membro", true)
        .queue()
    client.upsertCommand("hug","Abraça um Membro")
        .setGuildOnly(true)
        .addOption(OptionType.USER, "member", "Mencione o membro", true)
        .queue()
    client.upsertCommand("punch","Soca um Membro")
        .setGuildOnly(true)
        .addOption(OptionType.USER, "member", "Mencione o membro", true)
        .queue()
}
