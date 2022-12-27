package com.github.marciel404.bot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import static com.github.marciel404.bot.embeds.ActionsEmbed.*;

public class Actions extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        if (!event.isFromGuild())return;

        var member = Objects.requireNonNull(event.getOption("member")).getAsMember();
        var userCommand = Objects.requireNonNull(event.getMember());
        var selfBotUser = event.getJDA().getSelfUser();
        if (member == null) {event.reply("Não encontrei esse membro no servidor").queue();return;}

        switch (event.getName()) {

            case "kiss" -> {
                Button button;
                if (!member.getId().equals(userCommand.getId())) button = Button.primary("kiss-"+member.getId(),"Retribuir");
                else button = Button.primary("kiss-"+member.getId(),"Retribuir").asDisabled();
                event.replyEmbeds(
                        kissEmbed(
                                userCommand.getAsMention(),
                                member.getAsMention(),
                                selfBotUser.getAsMention()
                        )
                ).addActionRow(button).queue();
            }

            case "hug" -> {
                Button button;
                if (!member.getId().equals(userCommand.getId())) button = Button.primary("hug-"+member.getId(),"Retribuir");
                else button = Button.primary("hug-"+member.getId(),"Retribuir").asDisabled();
                event.replyEmbeds(hugEmbed(
                                    selfBotUser.getAsMention(),
                                    userCommand.getAsMention(),
                                    selfBotUser.getAsMention()
                                )
                ).setActionRow(button).queue();
            }

            case "punch" -> {
                Button button;
                if (!member.getId().equals(userCommand.getId())) button = Button.primary("punch-"+member.getId(),"Retribuir");
                else button = Button.primary("puch-"+member.getId(),"Retribuir").asDisabled();
                event.replyEmbeds(
                        punchEmbed(
                                userCommand.getAsMention(),
                                member.getAsMention(),
                                selfBotUser.getAsMention()
                        )
                ).setActionRow(button).queue();
            }

        }
    }
}