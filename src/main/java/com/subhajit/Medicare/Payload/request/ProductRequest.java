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
    private List<String> category;
    private double price;
    private double discountPercentage;
    private int quantityInStock;
    private String expiryDate;
    private String offerType;
}
