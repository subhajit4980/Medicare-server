package com.subhajit.Medicare.Repository;

import com.subhajit.Medicare.Models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByName(String name);
    List<Product> findByNameAndDiscountPercentage(String name,double discount);
    Optional<Product> findByItemId(String medicineId);
    List<Product> findByDiscountPercentage(double discount);
    List<Product> findByCategory(String category);
    Boolean existsByName(String name);
    Boolean existsByNameAndBrand(String name, String brand);

}