package com.github.marciel404.bot.utils;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import static com.github.marciel404.bot.utils.Configs.database;
import static com.github.marciel404.bot.utils.Configs.mongokey;

public interface DbInformation {
    static MongoClient client = MongoClients.create(new ConnectionString(mongokey));
    static MongoDatabase db = client.getDatabase(database);
    static MongoCollection<Document> invites = db.getCollection("invites");
}
