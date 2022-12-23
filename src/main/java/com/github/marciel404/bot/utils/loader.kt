package com.github.marciel404.bot.utils

import com.github.marciel404.bot.commands.Actions
import com.github.marciel404.bot.eventbuttons.ActionsButtons
import com.github.marciel404.bot.events.Member
import com.github.marciel404.bot.events.Message
import com.github.marciel404.bot.events.Ready
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.requests.GatewayIntent
import net.dv8tion.jda.api.utils.ChunkingFilter
import net.dv8tion.jda.api.utils.MemberCachePolicy
import net.dv8tion.jda.api.utils.cache.CacheFlag

val client = JDABuilder.createDefault(Configs.token)
            .addEventListeners(
                Ready(),
                Message(),
                Member(),
                Actions(),
                ActionsButtons()
            )
            .enableIntents(
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.DIRECT_MESSAGES,
                GatewayIntent.MESSAGE_CONTENT
            )
            .disableCache(CacheFlag.ACTIVITY)
            .setMemberCachePolicy(MemberCachePolicy.VOICE.or(MemberCachePolicy.OWNER))
            .setChunkingFilter(ChunkingFilter.NONE)
            .disableIntents(
                GatewayIntent.GUILD_PRESENCES,
                GatewayIntent.GUILD_MESSAGE_TYPING
            )
            .setLargeThreshold(50)
            .setActivity(Activity.listening("Minhas engrenagens"))
            .build()