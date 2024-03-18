package com.subhajit.Medicare.Models.DTO;

import com.subhajit.Medicare.Models.Review;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "Product")
public class Product {
    @Id
    private String itemId;
    @NotBlank
    private String name;
    @NotBlank
    private List<String> description;
    @NotBlank
    private double price;
    @NotBlank
    private double discountPercentage;
    @NotBlank
    private int quantityInStock;
    @NotBlank
    private String brand;
    @NotBlank
    private String manufactureDate;
    @NotBlank
    private List<String> imageUrl;
    @NotBlank
    private String category;
    private String subCategory;
    @NotBlank
    private List<String> tags;
    private String offerCode;
    @NotBlank
    private String shippingInfo;
    private String expiryDate;
    private String usageInstructions;
    private String pack_Size;
    private List<Double> weight;
    private String weightUnit;
    private List<Double> length;
    private String lengthUnit;
    private List<Double> width;
    private List<Double> height;
    private List<Double> capacity;
    private String capacityUnit;
    private List<String> color;
    private List<String> material;
    private List<String> promotionalInfo;
    private String activeIngredients;
    private List<String> sideEffects;
    private List<Review> reviews;
    private int buyer=0;
    private double rating=0.0;


    public Product(String name, List<String> description, double price, double discountPercentage,
                   int quantityInStock, String brand, String manufactureDate, List<String> imageUrl,
                   String category, List<String> tags, String offerCode, String shippingInfo) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.quantityInStock = quantityInStock;
        this.brand = brand;
        this.manufactureDate = manufactureDate;
        this.imageUrl = imageUrl;
        this.category = category;
        this.tags = tags;
        this.offerCode = offerCode;
        this.shippingInfo = shippingInfo;
    }
}
