package com.subhajit.Medicare.Controllers.API.User.Cart;

import com.subhajit.Medicare.Models.CartStatus;
import com.subhajit.Medicare.Models.CartSummary;
import com.subhajit.Medicare.Payload.request.CartRequest;
import com.subhajit.Medicare.Payload.response.MessageResponse;
import com.subhajit.Medicare.Repository.CartRepository;
import com.subhajit.Medicare.Services.Cart_Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CartController {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    Cart_Service cartService;

    // Endpoint to add an item to the cart
    @PostMapping("/addCart")
    public ResponseEntity<MessageResponse> addCart(@Valid @RequestBody CartRequest cartRequest) {
        MessageResponse messageResponse = cartService.addCart(cartRequest);
        return ResponseEntity.ok(messageResponse);
    }

    // Endpoint to delete an item from the cart
    @PutMapping("/deleteCartItem")
    public ResponseEntity<MessageResponse> deleteCartItem(@Valid @RequestParam("cartId") String cartId) throws Exception {
        MessageResponse messageResponse = cartService.deleteCartItem(cartId);
        return ResponseEntity.ok(messageResponse);
    }

    // Endpoint to increase the quantity of an item in the cart
    @PutMapping("/increaseItemInCart")
    public ResponseEntity<MessageResponse> increaseItemInCart(@Valid @RequestParam("cartId") String cartId, @RequestParam("increment") int increment) throws Exception {
        MessageResponse messageResponse = cartService.increaseItemInCart(cartId, increment);
        return ResponseEntity.ok(messageResponse);
    }

    // Endpoint to decrease the quantity of an item in the cart
    @PutMapping("/decreaseItemInCart")
    public ResponseEntity<MessageResponse> decreaseItemInCart(@Valid @RequestParam("cartId") String cartId, @RequestParam("decrement") int decrement) throws Exception {
        MessageResponse messageResponse = cartService.decreaseItemInCart(cartId, decrement);
        return ResponseEntity.ok(messageResponse);
    }

    // Endpoint to remove all items from the cart
    @PutMapping("/removeCart")
    public ResponseEntity<MessageResponse> removeCart(String userId) {
        MessageResponse messageResponse = cartService.removeCart(userId);
        return ResponseEntity.ok(messageResponse);
    }

    // Endpoint to retrieve all items in the cart for a given user
    @GetMapping("/getCart")
    public ResponseEntity<CartSummary> getCart(@Valid @RequestParam("userId") String userId) {
        return ResponseEntity.ok(cartService.getCart(userId));
    }
    @GetMapping("/getCartStatus/{userId}")
    public ResponseEntity<CartStatus> getCartStatus(@Valid  String userId)
    {
        return ResponseEntity.ok(cartService.cartStatusResponse(userId));
    }
}
