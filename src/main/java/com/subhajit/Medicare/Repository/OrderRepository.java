package com.subhajit.Medicare.Repository;

import com.subhajit.Medicare.Models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order, String> {
        List<Order> findByUsername(String username);
        Optional<Order> findByOrderId(String orderId);
        Boolean existsByUsername(String username);
        }