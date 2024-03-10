package com.subhajit.Medicare.Services;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.subhajit.Medicare.Models.Product;
import com.subhajit.Medicare.Repository.SearchRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SearchService implements SearchRepository {
    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoConverter  mongoConverter;
    @Override
    public List<Product> findByText(String text) {
        final List<Product> products = new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("Medicare");
        MongoCollection<Document> collection = database.getCollection("Prod uct");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "product")
                                .append("text",
                                        new Document("query", text)
                                                .append("path", List.of("name","brand","categories")))),
                new Document("$sort",
                        new Document("buyer", -1L)),
                new Document("$limit", 10L)));
        result.forEach(document->products.add(mongoConverter.read(Product.class,document)));
        return products;
    }
}
