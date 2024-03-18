package com.subhajit.Medicare.Models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class OrderItemSpec {
    private Double weight;
    private Double length;
    private Double width;
    private Double height;
    private String color;
    private String material;
}
