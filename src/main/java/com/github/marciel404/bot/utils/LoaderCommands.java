package com.github.marciel404.bot.utils;

import static com.github.marciel404.bot.utils.loader.*;

public class LoaderCommands {

    public static void load(){
        client.upsertCommand("teste","Teste").queue();
    }
}
