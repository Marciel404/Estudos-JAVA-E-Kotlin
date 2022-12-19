package com.github.marciel404.bot.eventbuttons;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static com.github.marciel404.bot.embeds.ActionsEmbed.hugembed;
import static com.github.marciel404.bot.embeds.ActionsEmbed.kissembed;

public class ActionsButtons extends ListenerAdapter {

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {

        if (event.isFromGuild()){
            var mention = event.getMessage().getEmbeds().get(0).getDescription();
            assert mention != null;
            if ( event.getComponentId().equals("kiss-"+event.getUser().getId())){
                event.replyEmbeds(
                        kissembed(
                                event.getUser().getAsMention(),
                                mention.replaceAll(
                                        "beijou "+ event.getUser().getAsMention(),
                                        ""
                                )
                        )
                ).queue();
                event.editButton(event.getButton().asDisabled()).queue();
            }else {
                event.reply("Esse botão não te pertence, ele pertence a <@"
                                + event.getComponentId()
                                    .replace("kiss-", "")+">")
                        .setEphemeral(true).queue();
            }
            if ( event.getComponentId().equals("hug-"+event.getUser().getId())){
                event.replyEmbeds(
                        hugembed(
                                event.getUser().getAsMention(),
                                mention.replaceAll(
                                        "beijou "+ event.getUser().getAsMention(),
                                        ""
                                )
                        )
                ).queue();
                event.editButton(event.getButton().asDisabled()).queue();
            }else {
                event.reply("Esse botão não te pertence, ele pertence a <@"
                                + event.getComponentId()
                                .replace("kiss-", "")+">")
                        .setEphemeral(true).queue();
            }
        }
    }
}
