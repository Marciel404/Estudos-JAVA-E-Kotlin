package com.github.marciel404.bot.utils

import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.requests.GatewayIntent
import net.dv8tion.jda.api.utils.ChunkingFilter
import net.dv8tion.jda.api.utils.MemberCachePolicy
import net.dv8tion.jda.api.utils.cache.CacheFlag


object Client{

    val client = JDABuilder.createDefault(Configs.token)
        .addEventListeners(
            com.github.marciel404.bot.events.Ready(),
            com.github.marciel404.bot.events.Message(),
            com.github.marciel404.bot.events.Member(),
            com.github.marciel404.bot.commands.Actions(),
            com.github.marciel404.bot.eventbuttons.ActionsButtons()
        )
        .disableCache(CacheFlag.ACTIVITY)
        .enableIntents(
            GatewayIntent.GUILD_MEMBERS,
            GatewayIntent.MESSAGE_CONTENT,
            GatewayIntent.GUILD_MESSAGES

        )
        .disableIntents(
            GatewayIntent.DIRECT_MESSAGES
        )
        .setMemberCachePolicy(MemberCachePolicy.VOICE.or(MemberCachePolicy.OWNER))
        .setChunkingFilter(ChunkingFilter.NONE)
        .setLargeThreshold(50)
        .setActivity(Activity.listening("Minhas engrenagens"))
        .build()
}