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
    @NotBlank
    private String itemId;
    @NotBlank
    private String userId;
    @NotBlank
    private int noOfQuantityToBuy;


}
