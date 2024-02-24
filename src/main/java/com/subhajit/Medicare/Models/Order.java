package com.subhajit.Medicare.Models;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "Order")
public class Order {
    @Id
    private String orderId;
    @NotBlank
    private String productId;
    @NotBlank
    private String userId;
    @NotBlank
    private  int orderQuantity;
    @NotBlank
    private String email;
    @NotBlank
    private String address;
    @NotBlank
    private  String pinNumber;
    @NotBlank
    private String mobileNumber;
    @NotBlank
    private String status;
    @NotBlank
    private  String orderedDate;
    @NotBlank
    private  String expectedDeliveryDate;
    @NotBlank
    private double price;
    @NotBlank
    private String imageUrl;
    @NotBlank
    private String paymentType;
    @NotBlank
    private Boolean paymentStatus;

    private String transectionId;

    public Order(String productId,int orderQuantity, String email, String address, String pinNumber, String mobileNumber, String status, String orderedDate, String expectedDeliveryDate, double price, String imageUrl) {
        this.productId = productId;
        this.orderQuantity=orderQuantity;
        this.email = email;
        this.address = address;
        this.pinNumber = pinNumber;
        this.mobileNumber = mobileNumber;
        this.status = status;
        this.orderedDate = orderedDate;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}

