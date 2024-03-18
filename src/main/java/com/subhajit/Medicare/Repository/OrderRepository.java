package com.subhajit.Medicare.Repository;

import com.subhajit.Medicare.Models.DTO.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order, String> {
        List<Order> findByUserId(String username);
        Optional<Order> findByOrderId(String orderId);
        Boolean existsByUserId(String username);
        }