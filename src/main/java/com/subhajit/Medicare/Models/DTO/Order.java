package com.subhajit.Medicare.Models.DTO;

import com.subhajit.Medicare.Models.Address;
import com.subhajit.Medicare.Models.OrderItemSpec;
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
    private OrderItemSpec orderSpec;
    @NotBlank
    private String userId;
    @NotBlank
    private  int orderQuantity;
    @NotBlank
    private Address address;
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

    public Order(String productId,int orderQuantity, Address address, String status, String orderedDate, String expectedDeliveryDate, double price, String imageUrl) {
        this.productId = productId;
        this.orderQuantity=orderQuantity;
        this.address = address;
        this.status = status;
        this.orderedDate = orderedDate;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}

