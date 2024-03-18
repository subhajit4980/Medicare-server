package com.subhajit.Medicare.Models.DTO;

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
@Document(collection = "Cart")
public class Cart {
    @Id
    private String cartId;
    @NotBlank
    private String itemId;
    private OrderItemSpec orderSpec;
    @NotBlank
    private String userId;
    @NotBlank
    private int noOfQuantityToBuy;
    private double price;
    private double discountPercentage;
    @NotBlank
    private String itemName;
    @NotBlank
    private String imageUrl;

    public Cart(String itemId, String userId, int noOfQuantityToBuy, String itemName,String imageUrl) {
        this.itemId = itemId;
        this.userId = userId;
        this.noOfQuantityToBuy = noOfQuantityToBuy;
        this.itemName = itemName;
        this.imageUrl=imageUrl;
    }
}
