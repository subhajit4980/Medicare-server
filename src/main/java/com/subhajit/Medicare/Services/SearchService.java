package com.subhajit.Medicare.Services;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.subhajit.Medicare.Models.DTO.Product;
import com.subhajit.Medicare.Repository.SearchRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SearchService implements SearchRepository {

    @Autowired
    private MongoClient mongoClient;

    @Autowired
    private MappingMongoConverter mongoConverter;

    @Override
    public List<Product> findByText(String text) {
        List<Product> products = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("Medicare");
        MongoCollection<Document> collection = database.getCollection("Product");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$match",
                        new Document("$or", Arrays.asList(
                                new Document("name", new Document("$regex", text).append("$options", "i")),
                                new Document("brand", new Document("$regex", text).append("$options", "i"))
                        ))
                ),
                new Document("$sort",
                        new Document("rating", -1)
                ),
                new Document("$limit", 10)
        ));

        result.forEach(document -> {
            Product product = mongoConverter.read(Product.class, document);
            products.add(product);
        });

        return products;
    }
}
