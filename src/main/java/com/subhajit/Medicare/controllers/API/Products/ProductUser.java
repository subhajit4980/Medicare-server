package com.subhajit.Medicare.controllers.API.Products;

import com.subhajit.Medicare.Models.Product;
import com.subhajit.Medicare.Repository.ProductRepository;
import com.subhajit.Medicare.Repository.OrderRepository;
import com.subhajit.Medicare.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/productUser")
//@CrossOrigin("*")
public class ProductUser {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;

    //    Read item data from database
    @GetMapping("/getItem")
    public List<Product> getItems() {
        return productRepository.findAll();
    }

    //    filter all products by discounts
    @GetMapping("/filterByDiscount")
    public List<Product> productByDiscount(@Valid @RequestParam("discount") double discount) {
        return productRepository.findByDiscountPercentage(discount);
    }

    //    filter particular product by discounts
    @GetMapping("/filterProductByDiscount")
    public List<Product> filterProductByDiscount(@Valid @RequestParam("discount") double discount, @Valid @RequestParam("product") String product) {
        return productRepository.findByNameAndDiscountPercentage(product.trim(), discount);
    }

    //    filter all products by category
    @GetMapping("/filterByCategory")
    public List<Product> filterByCategory(@Valid @RequestParam("category") String category) {
        return productRepository.findByCategory(category);
    }

    // filter all products by discount ranges
    @GetMapping("/filterByRangeDiscount")
    public List<Product> filterByLeastDiscount(@Valid @RequestParam("minDiscount") double minDiscount, @Valid @RequestParam("maxDiscount") double maxDiscount) {
        return productRepository.findAll().stream().filter(product -> product.getDiscountPercentage() >= minDiscount && product.getDiscountPercentage() <= maxDiscount).collect(Collectors.toList());
    }

    // filter particular product by discount ranges
    @GetMapping("/filterProductByRangeDiscount")
    public List<Product> filterProductByRangeDiscount(@Valid @RequestParam("minDiscount") double minDiscount, @Valid @RequestParam("maxDiscount") double maxDiscount, @Valid @RequestParam("product") String item) {
        return productRepository.findByName(item.trim()).stream().filter(product -> product.getDiscountPercentage() >= minDiscount && product.getDiscountPercentage() <= maxDiscount).collect(Collectors.toList());
    }

    //    filter products by popularity
    @GetMapping("/filterByPopularity")
    public List<Product> filterByPopularity() {
        List<Product> products = productRepository.findAll();
        products.sort(Comparator.comparing(Product::getBuyer).reversed());
        return products;
    }

    //    filter particular product by popularity
    @GetMapping("/filterProductByPopularity")
    public List<Product> filterProductByPopularity(@Valid @RequestParam("product") String product) {
        List<Product> products = productRepository.findByName(product);
        products.sort(Comparator.comparing(Product::getBuyer).reversed());
        return products;
    }
}
