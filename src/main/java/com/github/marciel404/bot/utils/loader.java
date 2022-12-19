package com.github.marciel404.bot.utils;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import static com.github.marciel404.bot.utils.Configs.token;

public interface loader {
    JDA client = JDABuilder.createDefault(token)
            .addEventListeners(
                    new com.github.marciel404.bot.events.Ready(),
                    new com.github.marciel404.bot.events.Message(),
                    new com.github.marciel404.bot.events.Member(),
                    new com.github.marciel404.bot.commands.Actions(),
                    new com.github.marciel404.bot.eventbuttons.ActionsButtons())
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
            .build();
}
