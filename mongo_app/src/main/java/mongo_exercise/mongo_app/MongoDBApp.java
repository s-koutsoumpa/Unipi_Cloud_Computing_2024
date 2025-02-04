package mongo_exercise.mongo_app;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBApp {
    public static void main(String[] args) {
        // MongoDB connection string
        String mongoUri = "mongodb://admin:password@mongodb-service:27017/?authSource=admin"; // Kubernetes Service name

        // Use the full type instead of 'var'
        MongoClient mongoClient = MongoClients.create(mongoUri);

        try {
            // Get the database and collection
            MongoDatabase database = mongoClient.getDatabase("movies_db");
            MongoCollection<Document> collection = database.getCollection("movies");

            // Query the database
            List<Document> movies = collection.find().into(new ArrayList<>());

            // Output the results
            for (Document movie : movies) {
                System.out.println(movie.toJson());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mongoClient.close();
        }
    }
}
