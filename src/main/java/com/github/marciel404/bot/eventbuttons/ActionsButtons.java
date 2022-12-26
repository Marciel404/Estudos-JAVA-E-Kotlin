package com.github.marciel404.bot.eventbuttons;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.GenericComponentInteractionCreateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static com.github.marciel404.bot.embeds.ActionsEmbed.*;

public class ActionsButtons extends ListenerAdapter {

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {

        if (!event.isFromGuild())return;

        var mention = event.getMessage().getEmbeds().get(0).getDescription();
        var user = event.getUser();
        if (mention == null) return;

        if( event.getComponentId().equals("kiss-"+user.getId())){
            event.replyEmbeds(
                    kissEmbed(
                            user.getAsMention(),
                            mention.replaceAll(
                                    "beijou "+ event.getUser().getAsMention(),
                                    ""
                            )
                    )
            ).queue();
            event.editButton(event.getButton().asDisabled()).queue();
        }
        else {
            event.reply("Esse botão não te pertence, ele pertence a <@"
                            + event.getComponentId()
                                .replace("kiss-", "")+">")
                    .setEphemeral(true).queue();
        }
        if ( event.getComponentId().equals("hug-"+user.getId())){
            event.replyEmbeds(
                    hugEmbed(
                            event.getUser().getAsMention(),
                            mention.replaceAll(
                                    "beijou "+ event.getUser().getAsMention(),
                                    ""
                            )
                    )
            ).queue();
            event.editButton(event.getButton().asDisabled()).queue();

        }
        else {
            event.reply("Esse botão não te pertence, ele pertence a <@"
                            + event.getComponentId()
                            .replace("kiss-", "")+">")
                    .setEphemeral(true).queue();
        }
    }
}
