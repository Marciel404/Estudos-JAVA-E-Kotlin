package com.github.marciel404.bot.events;

import com.github.marciel404.bot.db.Moderation;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import static com.github.marciel404.bot.utils.Configs.channels;

public class Message implements EventListener {

    @Override
    public void onEvent(@NotNull GenericEvent e) {

        if (e instanceof MessageReceivedEvent) {
            if (((MessageReceivedEvent) e).isFromGuild()) {
                if (((MessageReceivedEvent) e).getMessage().getContentDisplay().toLowerCase().contains("bane")) {
                    if (Objects.requireNonNull(((MessageReceivedEvent) e).getMember()).hasPermission(Permission.BAN_MEMBERS)){
                        var y = ((MessageReceivedEvent) e).getMessage().getMentions().getMentions().toArray().length;
                        for (int x = 0; y > x; x++) {
                            try{
                                Member member = ((MessageReceivedEvent) e).getMessage().getMentions().getMembers().get(x);
                                ((MessageReceivedEvent) e).getGuild().ban(member,0, TimeUnit.MILLISECONDS).queue();
                            } catch (Exception error){
                                ((MessageReceivedEvent) e).getChannel().sendMessage("Error: " + error).queue();
                            }
                        }
                    } else {
                        var y = ((MessageReceivedEvent) e).getMessage().getMentions().getMentions().toArray().length;
                        for (int x = 0; y > x; x++) {
                            Member member = ((MessageReceivedEvent) e).getMessage().getMentions().getMembers().get(x);
                            Moderation.addMember(member, 1);
                            if (Moderation.verify(member.getId()) >= 3) {
                                try {
                                    var channel = e.getJDA().getTextChannelById(channels[0]);
                                    if (channel != null) {
                                        channel.sendMessage(member.getAsMention() + "tem sugestões de ban de mais").queue();
                                    }
                                } catch (Exception error) {
                                    System.out.println("Error: " + error);
                                }
                            }
                        }
                    }
                } else if (((MessageReceivedEvent) e).getMessage().getContentDisplay().toLowerCase().contains("expulsa")){
                    if (Objects.requireNonNull(((MessageReceivedEvent) e).getMember()).hasPermission(Permission.KICK_MEMBERS)){
                        var y = ((MessageReceivedEvent) e).getMessage().getMentions().getMentions().toArray().length;
                        for (int x = 0; y > x; x++) {
                            try{
                                Member member = ((MessageReceivedEvent) e).getMessage().getMentions().getMembers().get(x);
                                member.kick().queue();
                            } catch (Exception error){
                                ((MessageReceivedEvent) e).getChannel().sendMessage("Error: " + error).queue();
                            }
                        }
                    } else {
                        var y = ((MessageReceivedEvent) e).getMessage().getMentions().getMentions().toArray().length;
                        for (int x = 0; y > x; x++) {
                            Member member = ((MessageReceivedEvent) e).getMessage().getMentions().getMembers().get(x);
                            Moderation.addMember(member, 1);
                            if (Moderation.verify(member.getId()) >= 3) {
                                try {
                                    var channel = e.getJDA().getTextChannelById(channels[0]);
                                    if (channel != null) {
                                        channel.sendMessage(member.getAsMention() + "tem sugestões de ban de mais").queue();
                                    }
                                } catch (Exception error) {
                                    System.out.println("Error: " + error);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}