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
@Document(collection = "addresses")
public class Address {
    @Id
    private String addressId;
    @NotBlank
    private String userId; // Reference to the user
    @NotBlank
    private String name; // Name associated with the address (e.g., John Doe)
    @NotBlank
    private String BuildingNumber;
    @NotBlank
    private String street; // Street address
    @NotBlank
    private String city; // City
    @NotBlank
    private String state; // State or Province
    @NotBlank
    private String postalCode; // Postal code
    @NotBlank
    private String country; // Country
    @NotBlank
    private String phone; // Phone number

    public Address(String userId, String name, String buildingNumber, String street, String city, String state, String postalCode, String country, String phone) {
        this.userId = userId;
        this.name = name;
        BuildingNumber = buildingNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
    }
}

