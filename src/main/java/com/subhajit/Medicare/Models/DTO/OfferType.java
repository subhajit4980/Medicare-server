package com.subhajit.Medicare.Models.DTO;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "offerTypes")
public class OfferType {

    @Id
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String offerCode;
    private String description;
    @NotBlank
    private List<Offer> OfferList;
    @Data
    private static class Offer {
        private  String offer_details;
        private double discount;
    }

}
