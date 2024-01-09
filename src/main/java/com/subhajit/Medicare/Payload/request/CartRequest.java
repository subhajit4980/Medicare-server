package com.subhajit.Medicare.Payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CartRequest {
    private String itemId;
    private String username;
    private  String medicineName;
    private int noOfQuantityToBuy;
}
