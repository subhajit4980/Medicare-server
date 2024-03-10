package com.subhajit.Medicare.Repository;

import com.subhajit.Medicare.Models.Product;

import java.util.List;

public interface SearchRepository {
    List<Product> findByText(String text);
}
