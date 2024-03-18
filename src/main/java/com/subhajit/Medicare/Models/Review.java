package com.subhajit.Medicare.Models;

import lombok.Data;

@Data
public class Review {
    private String userId;
    private String reviewMessage;
    private double rating;
}
