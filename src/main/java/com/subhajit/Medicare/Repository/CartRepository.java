package com.subhajit.Medicare.Repository;

import com.subhajit.Medicare.Models.Cart;
import com.subhajit.Medicare.Models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository  extends MongoRepository<Cart, String> {
        List<Cart> findByUserId(String username);
        Optional<Cart> findByCartId(String cartId);
        Boolean existsByUserId(String username);
}
