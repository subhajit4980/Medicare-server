package com.subhajit.Medicare.controllers.API.Order;

import com.subhajit.Medicare.Models.Cart;
import com.subhajit.Medicare.Models.Product;
import com.subhajit.Medicare.Models.Order;
import com.subhajit.Medicare.Payload.request.CartRequest;
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
@RequestMapping("/api/order")
public class OrderProduct {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CartRepository cartRepository;

    @PostMapping("/addCart")
    public ResponseEntity<?> addCart(@Valid @RequestBody CartRequest cartRequest) {
        Product item_obj = productRepository.findByItemId(cartRequest.getItemId()).orElseThrow(() -> new UsernameNotFoundException("item Not Found with"));
        if (item_obj.getQuantityInStock() == 0) {
            return ResponseEntity.badRequest().body("item out of stock");
        }
        Cart cart = new Cart(cartRequest.getItemId(), cartRequest.getUsername(), cartRequest.getNoOfQuantityToBuy());
        cartRepository.save(cart);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/deleteCartItem")
    public ResponseEntity<?> deleteCartItem(@Valid @RequestParam("cartId") String cartId) throws Exception {
        Cart cart = cartRepository.findByCartId(cartId).orElseThrow(() -> new Exception("Cart not found"));
        cartRepository.delete(cart);
        return ResponseEntity.ok("CartItem removed successfully");
    }

    @PostMapping("/increaseItemInCart")
    public ResponseEntity<?> increaseItemInCart(@Valid @RequestParam("cartId") String cartId, @RequestParam("increment") int increment) throws Exception {
        Cart cart = cartRepository.findByCartId(cartId).orElseThrow(() -> new Exception("Cart not found"));
        int quantity = cart.getNoOfQuantityToBuy() + increment;
        cart.setNoOfQuantityToBuy(quantity);
        cartRepository.save(cart);
        return ResponseEntity.ok("CartItem increase successfully");
    }

    @PostMapping("/decreaseItemInCart")
    public ResponseEntity<?> decreaseItemInCart(@Valid @RequestParam("cartId") String cartId, @RequestParam("decrement") int decrement) throws Exception {
        Cart cart = cartRepository.findByCartId(cartId).orElseThrow(() -> new Exception("Cart not found"));
        int quantity = cart.getNoOfQuantityToBuy();
        if (quantity > 0) {
            cart.setNoOfQuantityToBuy(quantity - decrement);
            cartRepository.save(cart);
        }
        return ResponseEntity.ok("CartItem decrease successfully");
    }

    @GetMapping("/cart")
    public List<Cart> getCart(@Valid @RequestParam("username") String username) {
        return cartRepository.findByUsername(username);
    }

    //    buy product
    @PostMapping("/buy")
    public ResponseEntity<?> updateitemAfterBuy(@Valid @RequestBody OrderRequest orderRequest) {
        Product item_obj = productRepository.findByItemId(orderRequest.getItemId()).orElseThrow(() -> new UsernameNotFoundException("item Not Found with"));
        if (item_obj.getQuantityInStock() == 0) {
            return ResponseEntity.badRequest().body("item out of stock");
        }
        if (userRepository.existsByUsername(orderRequest.getUsername())) {
            Order order = new Order(orderRequest.getItemId(), item_obj.getName(), orderRequest.getNoOfQuantityToBuy(), orderRequest.getUsername(),
                    orderRequest.getEmail(), orderRequest.getAddress(), orderRequest.getPinNumber(),
                    orderRequest.getMobileNumber(), false, LocalDate.now().toString(), LocalDate.now().plusDays(4).toString(),
                    item_obj.getPrice() * orderRequest.getNoOfQuantityToBuy(), item_obj.getImageUrl());
            // Update the item object with the new quantity
            item_obj.setQuantityInStock(item_obj.getQuantityInStock() - orderRequest.getNoOfQuantityToBuy());
            // Save the updated item object
            productRepository.save(item_obj);
            orderRepository.save(order);
            return ResponseEntity.ok("item ordered successfully");
        }
        return ResponseEntity.badRequest().body("Something went wrong");
    }
}
