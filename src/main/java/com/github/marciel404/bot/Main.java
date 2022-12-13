package com.github.marciel404.bot;

import net.dv8tion.jda.api.JDA;
import com.github.marciel404.bot.utils.LoaderCommands;

import static com.github.marciel404.bot.utils.loader.*;

public class Main {
    public static void main(String[] args){
        System.setProperty(org.slf4j.simple.SimpleLogger.LOG_FILE_KEY, "null");
        JDA client1 = client;
        LoaderCommands.load();
    }
}