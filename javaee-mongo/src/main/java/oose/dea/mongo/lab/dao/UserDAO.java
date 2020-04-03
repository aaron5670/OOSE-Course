package oose.dea.mongo.lab.dao;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

public class UserDAO implements IUserDAO {

    String connectionString = "mongodb://localhost:27017";
    MongoClient mongoClient = MongoClients.create(connectionString);
    MongoDatabase database = mongoClient.getDatabase("dea-onderzoek");
    MongoCollection<Document> collection = database.getCollection("users");

    @Override
    public List<Document> getUsers() {
        List<Document> users = new ArrayList<>();

        for (Document document : collection.find()) {
            users.add(document);
        }

        return users;
    }

    @Override
    public void addUser() {
        Document document = new Document("firstName", "Aaron")
                .append("lastName", "van den Berg")
                .append("age", 20)
                .append("email", "aaron@example.com");

        collection.insertOne(document);
    }

    @Override
    public void updateUser() {
        collection.updateOne(
                eq("firstName", "Aaron"),
                combine(set("age", 21))
        );
    }

    @Override
    public void deleteUser() {
        collection.deleteOne(eq("firstName", "Aaron"));
    }
}
