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
                Button button = Button.primary("kiss-"+member.getId(),"Retribuir");
                if (member.getId().equals(selfBotUser.getId())){

                    event.reply(
                            "Acho melhor sermos só amigos"
                    ).setEmbeds(
                            hugEmbed(
                                    selfBotUser.getAsMention(),
                                    userCommand.getAsMention())
                    ).queue();

                }
                else {

                    event.replyEmbeds(
                            kissEmbed(
                                    userCommand.getAsMention(),
                                    member.getAsMention())
                    ).addActionRow(button).queue();

                }
            }

            case "hug" -> {
                Button button = Button.primary("hug-"+member.getId(),"Retribuir");
                if (member.equals(event.getMember())){
                    event.reply(
                            "Você está tão solitario assim?\nAqui, deixa eu te abraçar")
                            .setEmbeds(hugEmbed(
                                    selfBotUser.getAsMention(),
                                    userCommand.getAsMention())
                            )
                            .setActionRow(button)
                            .queue();
                }
                else {
                    event.replyEmbeds(
                            hugEmbed(
                                    userCommand.getAsMention(),
                                    member.getAsMention())
                            )
                            .setActionRow(button)
                            .queue();
                }
            }
        }
    }
}