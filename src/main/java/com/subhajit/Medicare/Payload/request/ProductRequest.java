package com.subhajit.Medicare.Payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductRequest {
    private String itemId;
    private String name;
    private double price;
    private double discount;
    private int quantityInStock;
    private String expiryDate;
}
