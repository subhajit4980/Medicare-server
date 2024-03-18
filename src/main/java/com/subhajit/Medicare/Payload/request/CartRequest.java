package com.subhajit.Medicare.Payload.request;

import com.subhajit.Medicare.Models.OrderItemSpec;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CartRequest {
    @NotBlank
    private String itemId;
    private OrderItemSpec orderSpec;
    @NotBlank
    private String userId;
    @NotBlank
    private int noOfQuantityToBuy;


}
