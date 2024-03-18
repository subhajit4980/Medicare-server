package com.subhajit.Medicare.Services;

import com.subhajit.Medicare.Models.DTO.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyDataService {
    private final String jsonUrl = "http://localhost:8080/api/medicine/getMedicine"; // Replace with your JSON file URL

    @Autowired
    private RestTemplate restTemplate;

    public Product[] fetchDataFromJson() {
        Product[] response = (restTemplate.getForObject(jsonUrl, Product[].class));
        return response;
    }
}
