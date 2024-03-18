package com.subhajit.Medicare.Repository;

import com.subhajit.Medicare.Models.DTO.Product;

import java.util.List;

public interface SearchRepository {
    List<Product> findByText(String text);
}
