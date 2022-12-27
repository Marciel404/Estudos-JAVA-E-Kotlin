package com.github.marciel404.bot.eventbuttons;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import static com.github.marciel404.bot.embeds.ActionsEmbed.*;

public class ActionsButtons extends ListenerAdapter {

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {

        if (!event.isFromGuild())return;

        var mention = event.getMessage().getEmbeds().get(0).getDescription();
        var user = event.getUser();
        var selfBotUser = event.getJDA().getSelfUser();
        if (mention == null) return;

        if( event.getComponentId().equals("kiss-"+user.getId())){
            event.replyEmbeds(
                    kissEmbed(
                            user.getAsMention(),
                            mention.replaceAll(
                                    "beijou "+ user.getAsMention(),
                                    ""
                            ),
                            selfBotUser.getAsMention()
                    )
            ).queue();
            event.editButton(event.getButton().asDisabled()).queue();
        } else if ( event.getComponentId().equals("hug-"+user.getId())){
            event.replyEmbeds(
                    hugEmbed(
                            event.getUser().getAsMention(),
                            mention.replaceAll(
                                    "abraçou "+ user.getAsMention(),
                                    ""
                            ),
                            selfBotUser.getAsMention()
                    )
            ).queue();
            event.editButton(event.getButton().asDisabled()).queue();
        } else if (event.getComponentId().equals("punch-"+user.getId())) {
            event.replyEmbeds(
                    hugEmbed(
                            event.getUser().getAsMention(),
                            mention.replaceAll(
                                    "abraçou "+ user.getAsMention(),
                                    ""
                            ),
                            selfBotUser.getAsMention()
                    )
            ).queue();
            event.editButton(event.getButton().asDisabled()).queue();
        } else {
            event.reply(String.format("Esse botão não te pertence, ele pertence a <@%s>",
                    event.getComponentId()
                            .substring(
                                    event.getComponentId()
                                            .lastIndexOf("-")+1
                            )
                    )
            ).setEphemeral(true).queue();
        }
    }
}