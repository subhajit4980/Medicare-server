package com.subhajit.Medicare.Controllers.API.Order;

import com.subhajit.Medicare.Models.Product;
import com.subhajit.Medicare.Models.Order;
import com.subhajit.Medicare.Payload.request.OrderRequest;
import com.subhajit.Medicare.Repository.CartRepository;
import com.subhajit.Medicare.Repository.ProductRepository;
import com.subhajit.Medicare.Repository.OrderRepository;
import com.subhajit.Medicare.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CartRepository cartRepository;
    //    buy product
    @PostMapping("/order")
    public ResponseEntity<?> orderItem(@Valid @RequestBody OrderRequest orderRequest) {
        Product item_obj = productRepository.findByItemId(orderRequest.getItemId()).orElseThrow(() -> new UsernameNotFoundException("item Not Found with"));
        if (item_obj.getQuantityInStock() == 0) {
            return ResponseEntity.badRequest().body("item out of stock");
        }
        if (userRepository.existsByUsername(orderRequest.getUsername())) {
            Order order = new Order(
                    orderRequest.getItemId(),
//                    item_obj.getName(),
                    orderRequest.getNoOfQuantityToBuy(),
                    orderRequest.getUsername(),
                    orderRequest.getEmail(),
                    orderRequest.getAddress(),
                    orderRequest.getPinNumber(),
                    orderRequest.getMobileNumber(),
                    "",
                    LocalDate.now().toString(),
                    LocalDate.now().plusDays(4).toString(),
                    item_obj.getPrice() * orderRequest.getNoOfQuantityToBuy(),
                    item_obj.getImageUrl());
            // Update the item object with the new quantity
            item_obj.setQuantityInStock(item_obj.getQuantityInStock() - orderRequest.getNoOfQuantityToBuy());
            // Save the updated item object
            productRepository.save(item_obj);
            orderRepository.save(order);
            return ResponseEntity.ok("item ordered successfully");
        }
        return ResponseEntity.badRequest().body("Something went wrong");
    }
    @GetMapping("/showOrder/{username}")
    public  ResponseEntity<List<Order>> showOrder(@Valid @PathVariable String username)
    {
        List<Order> order = orderRepository.findByUsername(username);
        return ResponseEntity.ok(order);
    }
}
