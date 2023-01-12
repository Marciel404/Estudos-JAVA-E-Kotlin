package com.github.marciel404.bot

import com.github.marciel404.bot.utils.Client
import com.github.marciel404.bot.utils.loadCommands
import org.slf4j.simple.SimpleLogger

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        System.setProperty(SimpleLogger.LOG_FILE_KEY, "logs")
        try {
            Client.client
            loadCommands()
        } catch (error: Exception) {
            println("Error: $error")
        }
    }
}