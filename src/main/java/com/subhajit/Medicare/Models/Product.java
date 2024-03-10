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
    private List<String> imageUrl;
    @NotBlank
    private String category;
    @NotBlank
    private List<String> tags;
    @NotBlank
    private String offerType;
    @NotBlank
    private String shippingInfo;

    private String expiryDate;
    private String usageInstructions;
    private String pack_Size;
    private List<Double> weight;
    private String weightUnit;
    private double length;
    private String lengthUnit;
    private double width;
    private double height;
    private List<String> color;
    private List<String> material;
    private String promotionalInfo;
    private String activeIngredients;
    private List<String> sideEffects;
    private List<String> reviews;
    private int buyer=0;
    private double rating=0.0;


    public Product(String name, List<String> description, double price, double discountPercentage,
                   int quantityInStock, String brand, String manufactureDate, List<String> imageUrl,
                   String category, List<String> tags, String offerType, String shippingInfo) {
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
        this.offerType = offerType;
        this.shippingInfo = shippingInfo;
    }

//    public Product(String name, double price, double discount, int quantityInStock, String expiryDate) {
//        this.name = name;
//        this.price = price;
//        this.discountPercentage = discount;
//        this.quantityInStock = quantityInStock;
//        this.expiryDate = expiryDate;
//    }
}
