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
@Document(collection = "Cart")
public class Cart {
    @Id
    private String cartId;
    @NotBlank
    private String itemId;
    @NotBlank
    private String userId;
    @NotBlank
    private int noOfQuantityToBuy;
    @NotBlank
    private String itemName;

    public Cart(String itemId, String userId, int noOfQuantityToBuy, String itemName) {
        this.itemId = itemId;
        this.userId = userId;
        this.noOfQuantityToBuy = noOfQuantityToBuy;
        this.itemName = itemName;
    }
}
