package com.subhajit.Medicare.Payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductRequest {
    private String itemId;
    private String name;
    private String category;
    private double price;
    private double discountPercentage;
    private int quantityInStock;
    private String expiryDate;
    private String offerType;
    private List<String> tags;
    private String shippingInfo;
    private List<String> imageUrl;
    private List<String> description;
    private String usageInstructions;
    private String pack_Size;
    private List<Double> weight;
    private double length;
    private double width;
    private double height;
    private List<String> color;
    private List<String> sideEffects;

}
