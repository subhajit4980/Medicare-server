package com.subhajit.Medicare.Payload.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PaymentLinkResponse {
    private String payment_link_url;
    private String payment_link_Id;
}
