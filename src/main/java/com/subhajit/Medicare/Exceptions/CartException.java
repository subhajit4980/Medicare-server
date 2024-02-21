package com.subhajit.Medicare.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartException extends RuntimeException {

    private final String errorCode;

    public CartException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}


// Cart_Controller.java
//package com.subhajit.Medicare.controllers.API.Order;
//
//import com.subhajit.Medicare.Models.Cart;
//import com.subhajit.Medicare.Payload.request.CartRequest;
//import com.subhajit.Medicare.services.CartService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//        import java.util.List;
//
//@RestController
//@RequestMapping("/api/cart")
//public class Cart_Controller {
//
//    @Autowired
//    CartService cartService;
//
//    @PostMapping("/addCart")
//    public ResponseEntity<?> addCart(@Valid @RequestBody CartRequest cartRequest) {
//        return cartService.addCart(cartRequest);
//    }
//
//    @PostMapping("/deleteCartItem")
//    public ResponseEntity<?> deleteCartItem(@Valid @RequestParam("cartId") String cartId) {
//        return cartService.deleteCartItem(cartId);
//    }
//
//    @PostMapping("/increaseItemInCart")
//    public ResponseEntity<?> increaseItemInCart(@Valid @RequestParam("cartId") String cartId, @RequestParam("increment") int increment) {
//        return cartService.increaseItemInCart(cartId, increment);
//    }
//
//    @PostMapping("/decreaseItemInCart")
//    public ResponseEntity<?> decreaseItemInCart(@Valid @RequestParam("cartId") String cartId, @RequestParam("decrement") int decrement) {
//        return cartService.decreaseItemInCart(cartId, decrement);
//    }
//
//    @GetMapping("/cart")
//    public List<Cart> getCart(@Valid @RequestParam("username") String username) {
//        return cartService.getCart(username);
//    }
//
//}


