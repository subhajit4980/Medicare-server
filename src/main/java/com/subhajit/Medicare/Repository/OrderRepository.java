package com.subhajit.Medicare.Repository;

import com.subhajit.Medicare.Models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order, String> {
        Optional<Order> findByUsername(String username);
        Boolean existsByUsername(String username);
        }