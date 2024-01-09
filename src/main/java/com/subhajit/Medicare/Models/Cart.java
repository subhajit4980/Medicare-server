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
    private String medicineId;
//    private String medicineName;
    @NotBlank
    private String username;
    @NotBlank
    private int noOfQuantityToBuy;

    public Cart(String medicineId, String username, int noOfQuantityToBuy) {
        this.medicineId = medicineId;
        this.username = username;
        this.noOfQuantityToBuy = noOfQuantityToBuy;
    }
}
