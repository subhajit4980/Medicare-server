package com.subhajit.Medicare.Models;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
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
    private String expiryDate;
    @NotBlank
    private String usageInstructions;
    @NotBlank
    private String imageUrl;
    @NotBlank
    private String pack_Size;
    @NotBlank
    private String category;
    private List<String> reviews;
    private boolean availabilityStatus;
    private String activeIngredients;
    private List<String> sideEffects;
    private int buyer;
    private double rating;
    @NotBlank
    private String offerType;

    public Product(String name, List<String> description, double price, double discount, int quantityInStock, String manufacturer, String manufactureDate, String expiryDate, String activeIngredients, String usageInstructions, String imageUrl, int buyer, double rating) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.discountPercentage = discount;
        this.quantityInStock = quantityInStock;
        this.brand = manufacturer;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.activeIngredients = activeIngredients;
        this.usageInstructions = usageInstructions;
        this.imageUrl = imageUrl;
        this.buyer = buyer;
        this.rating = rating;
    }

//    public Product(String name, double price, double discount, int quantityInStock, String expiryDate) {
//        this.name = name;
//        this.price = price;
//        this.discountPercentage = discount;
//        this.quantityInStock = quantityInStock;
//        this.expiryDate = expiryDate;
//    }
}
