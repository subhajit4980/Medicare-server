//package com.subhajit.Medicare.Services;
//
//import com.subhajit.Medicare.Models.Cart;
//import com.subhajit.Medicare.Repository.CartRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class CartService {
//
//    private final CartRepository cartRepository;
////
////    // Create or update a cart for a given user
////    public Cart saveCart(String username, Cart cart) {
////        cart.setUsername(username);
////        return cartRepository.save(cart);
////    }
//
//    // Get all the items in a cart for a given user
//    public List<Cart> getCart(String username) {
//        return cartRepository.findByUsername(username);
//    }
//
//    // Add an item to a cart for a given user
//    public Cart addItem(String username, Cart item) {
//        Cart cart = getCart(username);
//        cart.addItem(item);
//        return saveCart(username, cart);
//    }
//
//    // Remove an item from a cart for a given user
//    public Cart removeItem(String username, Long itemId) {
//        Cart cart = getCart(username);
//        cart.removeItem(itemId);
//        return saveCart(username, cart);
//    }
//
//    // Update the quantity of an item in a cart for a given user
//    public Cart updateItem(String username, Long itemId, int quantity) {
//        Cart cart = getCart(username);
//        cart.updateItem(itemId, quantity);
//        return saveCart(username, cart);
//    }
//
//
//    // Clear all the items in a cart for a given user
//    public void clearCart(String username) {
//        Cart cart = getCart(username);
//        cart.clearItems();
//        saveCart(username, cart);
//    }
//}

// CartService.java
package com.subhajit.Medicare.Services;

import com.subhajit.Medicare.Exceptions.CartException;
import com.subhajit.Medicare.Exceptions.ProductOutOfStockException;
import com.subhajit.Medicare.Models.Cart;
import com.subhajit.Medicare.Models.Product;
import com.subhajit.Medicare.Payload.request.CartRequest;
import com.subhajit.Medicare.Repository.CartRepository;
import com.subhajit.Medicare.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Cart_Service {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    public ResponseEntity<?> addCart(CartRequest cartRequest) {
        Product item_obj = productRepository.findByItemId(cartRequest.getItemId()).orElseThrow(() ->
                new CartException("Product not found with item id: " + cartRequest.getItemId(),"CART_NOT_FOUND"));
        if (item_obj.getQuantityInStock() == 0) {
            throw new ProductOutOfStockException("Product out of stock with item id: " + cartRequest.getItemId(),"PRODUCT_EMPTY");
        }
        Cart cart = new Cart(cartRequest.getItemId(), cartRequest.getUsername(), cartRequest.getNoOfQuantityToBuy());
        cartRepository.save(cart);
        return ResponseEntity.ok(cart);
    }
    // Remove an item from a cart for a given user
    public ResponseEntity<?> deleteCartItem(String cartId) {
        Cart cart = cartRepository.findByCartId(cartId).orElseThrow(() ->
                new CartException("Cart not found with cart id: " + cartId,"CART_NOT_FOUND"));
        cartRepository.delete(cart);
        return ResponseEntity.ok("CartItem removed successfully");
    }

    public ResponseEntity<?> increaseItemInCart(String cartId, int increment) {
        Cart cart = cartRepository.findByCartId(cartId).orElseThrow(() ->
                new CartException("Cart not found with cart id: " + cartId,"CART_NOT_FOUND"));
        int quantity = cart.getNoOfQuantityToBuy() + increment;
        cart.setNoOfQuantityToBuy(quantity);
        cartRepository.save(cart);
        return ResponseEntity.ok("CartItem increase successfully");
    }

    public ResponseEntity<?> decreaseItemInCart(String cartId, int decrement) {
        Cart cart = cartRepository.findByCartId(cartId).orElseThrow(() ->
                new CartException("Cart not found with cart id: " + cartId,"CART_NOT_FOUND"));
        int quantity = cart.getNoOfQuantityToBuy();
        if (quantity > 0) {
            cart.setNoOfQuantityToBuy(quantity - decrement);
            cartRepository.save(cart);
        }
        return ResponseEntity.ok("CartItem decrease successfully");
    }

    public List<Cart> getCart(String username) {
        return cartRepository.findByUsername(username);
    }

}
