package com.github.marciel404.bot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.Random;
import static com.github.marciel404.bot.embeds.ActionsEmbed.*;

public class Actions extends ListenerAdapter {

    Object[] caracoroa = {"Cara", "Coroa"};

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        if (!event.isFromGuild())return;
        Button button;

        var userCommand = Objects.requireNonNull(event.getMember());
        var selfBotUser = event.getJDA().getSelfUser();

        switch (event.getName()) {

            case "kiss" -> {
                var member = Objects.requireNonNull(event.getOption("member")).getAsMember();
                if (member == null) {event.reply("Não encontrei esse membro no servidor").queue();return;}

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

                var member = Objects.requireNonNull(event.getOption("member")).getAsMember();
                if (member == null) {event.reply("Não encontrei esse membro no servidor").queue();return;}

                if (!member.getId().equals(userCommand.getId())) button = Button.primary("hug-"+member.getId(),"Retribuir");
                else button = Button.primary("hug-"+member.getId(),"Retribuir").asDisabled();
                event.replyEmbeds(hugEmbed(
                                    userCommand.getAsMention(),
                                    member.getAsMention(),
                                    selfBotUser.getAsMention()
                                )
                ).setActionRow(button).queue();
            }

            case "punch" -> {
                var member = Objects.requireNonNull(event.getOption("member")).getAsMember();
                if (member == null) {event.reply("Não encontrei esse membro no servidor").queue();return;}

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

            case "slap" -> {
                var member = Objects.requireNonNull(event.getOption("member")).getAsMember();
                if (member == null) {event.reply("Não encontrei esse membro no servidor").queue();return;}

                if (!member.getId().equals(userCommand.getId())) button = Button.primary("slap-"+member.getId(),"Retribuir");
                else button = Button.primary("slap-"+member.getId(),"Retribuir").asDisabled();
                event.replyEmbeds(
                        slapEmbed(
                                userCommand.getAsMention(),
                                member.getAsMention(),
                                selfBotUser.getAsMention()
                        )
                ).setActionRow(button).queue();
            }

            case "lick" -> {
                var member = Objects.requireNonNull(event.getOption("member")).getAsMember();
                if (member == null) {event.reply("Não encontrei esse membro no servidor").queue();return;}

                if (!member.getId().equals(userCommand.getId())) button = Button.primary("lick-"+member.getId(),"Retribuir");
                else button = Button.primary("lick-"+member.getId(),"Retribuir").asDisabled();
                event.replyEmbeds(
                        lickEmbed(
                                userCommand.getAsMention(),
                                member.getAsMention(),
                                selfBotUser.getAsMention()
                        )
                ).setActionRow(button).queue();
            }

            /*case "cafune" -> {
                var member = Objects.requireNonNull(event.getOption("member")).getAsMember();
                if (member == null) {event.reply("Não encontrei esse membro no servidor").queue();return;}

                if (!member.getId().equals(userCommand.getId())) button = Button.primary("lick-"+member.getId(),"Retribuir");
                else button = Button.primary("lick-"+member.getId(),"Retribuir").asDisabled();

                event.replyEmbeds(
                        cafuneEmbed(
                                userCommand.getAsMention(),
                                member.getAsMention(),
                                selfBotUser.getAsMention()
                        )
                ).setActionRow(button).queue();
            }*/

            case "flip-coin" -> {

                int y;

                if (event.getOption("qnt") == null) y = 1;
                else y = event.getOption("qnt").getAsInt();

                event.deferReply(true).queue();

                for (int x = 0; y > x; x++){

                    event.getHook().sendMessage(
                            String.format(
                                    "Caiu %s",
                                    caracoroa[new Random().nextInt(2)]
                            )
                    ).setEphemeral(true).queue();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            case "cat" -> {

                event.replyEmbeds(
                        catEmbed()
                ).queue();
            }
        }
    }
}