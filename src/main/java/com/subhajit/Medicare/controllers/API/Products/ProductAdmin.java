package com.subhajit.Medicare.controllers.API.Products;

import com.subhajit.Medicare.Models.Product;
import com.subhajit.Medicare.Payload.request.ProductRequest;
import com.subhajit.Medicare.Payload.response.MessageResponse;
import com.subhajit.Medicare.Repository.ProductRepository;
import com.subhajit.Medicare.Repository.OrderRepository;
import com.subhajit.Medicare.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Admin")
public class ProductAdmin {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;

    //add item to the database
    @PostMapping("/create")
    public ResponseEntity<?> addItem(@Valid @RequestBody Product item) {
        if (productRepository.existsByNameAndBrand(item.getName(), item.getBrand())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("item already added!"));
        }
        Product item_obj = new Product(item.getName().trim(), item.getDescription(), item.getPrice(), item.getDiscountPercentage(), item.getQuantityInStock(), item.getBrand().trim(), item.getManufactureDate(), item.getExpiryDate(), item.getActiveIngredients(), item.getUsageInstructions(), item.getImageUrl(), item.getBuyer(), item.getRating());
        item_obj.setExpiryDate(item.getExpiryDate());
        item_obj.setQuantityInStock(item.getQuantityInStock());
        item_obj.setPack_Size(item.getPack_Size());
        if (item.getCategory().equalsIgnoreCase("medicine"))
            item_obj.setSideEffects(item.getSideEffects());
        item_obj.setBuyer(0);
        item_obj.setRating(0.0);
        item_obj.setAvailabilityStatus(true);
        item_obj.setCategory(item.getCategory());
        productRepository.save(item_obj);
        return ResponseEntity.ok(new MessageResponse("item  added successfully"));
    }

    //update item data in database
    @PostMapping("/update")
    public ResponseEntity<?> updateItem(@Valid @RequestBody ProductRequest item) {
        if (productRepository.existsById(item.getItemId())) {
            Product item_obj = productRepository.findByItemId(item.getItemId()).orElseThrow(() -> new UsernameNotFoundException("item Not Found with name: " + item.getName()));
            if (item.getQuantityInStock() >= 0)
                item_obj.setQuantityInStock(item.getQuantityInStock());
            if (item.getPrice() > 0)
                item_obj.setPrice(item.getPrice());
            if (item.getDiscount() >= 0)
                item_obj.setDiscountPercentage(item.getDiscount());
            if (item.getExpiryDate() != null && item.getQuantityInStock() >= 0)
                item_obj.setExpiryDate(item.getExpiryDate());
            productRepository.save(item_obj);
            return ResponseEntity.ok(item_obj);
        } else return ResponseEntity.badRequest().body("item Not Found with name: " + item.getName());
    }

    //    delete item from database
    @PostMapping("/delete")
    public ResponseEntity<?> deleteItem(@Valid @RequestBody ProductRequest item) {
        Product item_obj = productRepository.findByItemId(item.getItemId()).orElseThrow(() -> new UsernameNotFoundException("item Not Found with name: " + item.getName()));
        productRepository.delete(item_obj);
        return ResponseEntity.ok("Product was successfully deleted");
    }
}
