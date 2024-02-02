package com.subhajit.Medicare.Payload.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UpdatePaymentResponse {
    String message;
    boolean status;
}
