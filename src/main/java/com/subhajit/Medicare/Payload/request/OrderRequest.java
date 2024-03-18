package com.subhajit.Medicare.Payload.request;

import com.subhajit.Medicare.Models.Address;
import com.subhajit.Medicare.Models.OrderItemSpec;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderRequest {
    @NotBlank
    private String itemId;
    @NotBlank
    private String userId;
    private OrderItemSpec orderItemSpec;
    @NotBlank
    private int NoOfQuantityToBuy;
    @NotBlank
    private Address address;
    @NotBlank
    private String paymentType;
}
