package pl.sdacademy.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.sdacademy.db.mongo.Movie;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.eq;
import static org.assertj.core.api.Assertions.assertThat;

public class mongotest {

    @DisplayName("show how to create mongo movie collection and query it")
    @Test
    void collection() {
        // given
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("orders");
        Document profile = new Document("dateOfBirth", "1984.02.28").append("firstName", "Mike").append("lastName", "Tyson");
        Document userDoc = new Document("name", "Mike").append("profile", profile);


        // when
        MongoCollection<Document> collection = database.getCollection("testCollection");
        collection.insertOne(userDoc);

        // then
        User findUser = collection.find(eq("name", "Mike")).first();
        assertThat(findUser.getName()).getisEqualTo("title of the movie");
    }
}
