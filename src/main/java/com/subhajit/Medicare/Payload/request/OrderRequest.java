package com.subhajit.Medicare.Payload.request;

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
    private int NoOfQuantityToBuy;
    @NotBlank
    private String email;
    @NotBlank
    private String address;
    @NotBlank
    private  String pinNumber;
    @NotBlank
    private String mobileNumber;
    @NotBlank
    private String paymentType;
}
