package com.github.marciel404.bot.db;

import com.mongodb.ConnectionString;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import net.dv8tion.jda.api.entities.Member;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

import static com.github.marciel404.bot.utils.Configs.database;
import static com.github.marciel404.bot.utils.Configs.mongokey;
import static com.mongodb.client.model.Filters.eq;

public class Moderation {
    static MongoClient client = MongoClients.create(new ConnectionString(mongokey));
    static MongoDatabase db = client.getDatabase(database);
    static MongoCollection invites = db.getCollection("invites");

    public static void addMember(Member memberId, Integer qnt){

        try{
            var query = new Document()
                    .append("_id", memberId.getId());

            var update = Updates.combine(
                    Updates.inc("qnt", + qnt)
            );

            var upsert = new UpdateOptions().upsert(true);

            invites.updateOne(query,update,upsert);

            System.out.println("Tudo Certo");
        } catch (MongoException error){
            System.out.println("Error: "+error);
        }
    }

    public static Integer verify(Member memberId){
        Bson projectionFields = Projections.fields(
                Projections.include("qnt"),
                Projections.excludeId());

        Document db = (Document) invites.find(eq("_id",""+memberId.getId()))
                .projection(Projections.fields(projectionFields)).first();

        JSONObject json = new JSONObject(db);

        return (Integer) json.get("qnt");

    }

}
