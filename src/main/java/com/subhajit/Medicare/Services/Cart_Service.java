package com.subhajit.Medicare.Services;

import com.subhajit.Medicare.Exceptions.CartException;
import com.subhajit.Medicare.Exceptions.ProductException;
import com.subhajit.Medicare.Models.*;
import com.subhajit.Medicare.Models.DTO.Cart;
import com.subhajit.Medicare.Models.DTO.Product;
import com.subhajit.Medicare.Payload.request.CartRequest;
import com.subhajit.Medicare.Payload.response.MessageResponse;
import com.subhajit.Medicare.Repository.CartRepository;
import com.subhajit.Medicare.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class Cart_Service {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    // Method to add an item to the cart
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public MessageResponse addCart(CartRequest cartRequest) {
        // Retrieve the product from the database based on the item id
        Product item = productRepository.findByItemId(cartRequest.getItemId()).orElseThrow(() -> new CartException("Product not found with item id: " + cartRequest.getItemId(), "CART_NOT_FOUND", HttpStatus.NOT_FOUND));

        // Check if the item is out of stock
        if (item.getQuantityInStock() <= cartRequest.getNoOfQuantityToBuy()) {
            throw new CartException("Available quantity of " + item.getName() + " is " + item.getQuantityInStock(), "PRODUCT_NOT_AVAILABLE",HttpStatus.NOT_ACCEPTABLE);
        }

        // Create a new cart object and save it to the database
        Cart cart = new Cart(cartRequest.getItemId(), cartRequest.getUserId(), cartRequest.getNoOfQuantityToBuy(), item.getName(), item.getImageUrl().get(0));
        cart.setOrderSpec(cartRequest.getOrderSpec());
        cartRepository.save(cart);
        return new MessageResponse("Item added to Cart successfully");
    }

    // Method to remove an item from the cart
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public MessageResponse deleteCartItem(String cartId) {
        Cart cart = cartRepository.findByCartId(cartId).orElseThrow(() -> new CartException("Cart not found with cart id: " + cartId, "CART_NOT_FOUND",HttpStatus.NOT_FOUND));
        cartRepository.delete(cart);
        return new MessageResponse(cart.getItemName() + " removed successfully");
    }

    // Method to increase the quantity of an item in the cart
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public MessageResponse increaseItemInCart(String cartId, int increment) {
        Cart cart = cartRepository.findByCartId(cartId).orElseThrow(() -> new CartException("Cart not found with cart id: " + cartId, "CART_NOT_FOUND",HttpStatus.NOT_FOUND));
        int quantity = cart.getNoOfQuantityToBuy() + increment;
        // Retrieve the product from the database based on the item id
        Product item = productRepository.findByItemId(cart.getItemId()).orElseThrow(() -> new CartException("Product not found with item id: " + cart.getItemId(), "CART_NOT_FOUND",HttpStatus.NOT_FOUND));

        // Check if the item is out of stock
        if (item.getQuantityInStock() < quantity) {
            throw new CartException("Available quantity of " + cart.getItemName() + " is " + item.getQuantityInStock(), "PRODUCT_NOT_AVAILABLE",HttpStatus.NOT_ACCEPTABLE);
        }
        cart.setNoOfQuantityToBuy(quantity);
        cartRepository.save(cart);
        return new MessageResponse(cart.getItemName() + " increase by " + increment + " successfully");
    }

    // Method to decrease the quantity of an item in the cart
    @Transactional(isolation = Isolation.REPEATABLE_READ)

    public MessageResponse decreaseItemInCart(String cartId, int decrement) {
        Cart cart = cartRepository.findByCartId(cartId).orElseThrow(() -> new CartException("Cart not found with cart id: " + cartId, "CART_NOT_FOUND",HttpStatus.NOT_FOUND));
        int quantity = cart.getNoOfQuantityToBuy();
        if (quantity > decrement) {
            cart.setNoOfQuantityToBuy(quantity - decrement);
            cartRepository.save(cart);
        } else {
            throw new CartException("item quantity not less than 1", "NOT_PERMITTED",HttpStatus.BAD_REQUEST);
        }
        return new MessageResponse(cart.getItemName() + " decrease by " + decrement + " successfully");
    }
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    // Method to remove all items from the cart
    public MessageResponse removeCart(String userId) {
        try {
            List<Cart> cartlist = cartRepository.findByUserId(userId);
            List<String> cartIds = cartlist.stream().map(Cart::getCartId).toList();
            cartRepository.deleteAllById(cartIds);
        } catch (Exception e) {
            throw new CartException("Cart not found with cart id: ", "CART_NOT_FOUND",HttpStatus.NOT_FOUND);
        }
        return new MessageResponse("All cart items removed successfully");
    }

    // Method to retrieve all items in the cart for a given user
    public synchronized  CartSummary getCart(String userId) {
        List<Cart> carts=cartRepository.findByUserId(userId);
        double totalPrice=0.0;
        double discountPrice=0.0;
        for (Cart cart :carts) {
            Product item = productRepository.findByItemId(cart.getItemId()).orElseThrow(() -> new ProductException("item Not Found with", "NOT_FOUND", HttpStatus.NOT_FOUND));
            cart.setPrice(item.getPrice());
            totalPrice+=item.getPrice();
            discountPrice+=((item.getPrice()*item.getDiscountPercentage())/100);
            cart.setDiscountPercentage(item.getDiscountPercentage());
        }
        return new CartSummary(carts,totalPrice,discountPrice,totalPrice-discountPrice);
    }
    public synchronized CartStatus cartStatusResponse(String userId )  {
        try {
            List<Cart> carts = cartRepository.findByUserId(userId);
            List<Cart> outOfStock = new ArrayList<>();
            List<Cart> inStock = new ArrayList<>();
            for (Cart cart : carts) {
                Product item = productRepository.findByItemId(cart.getItemId()).orElseThrow(() -> new ProductException("item Not Found with", "NOT_FOUND", HttpStatus.NOT_FOUND));
                if (item.getQuantityInStock() < cart.getNoOfQuantityToBuy()) outOfStock.add(cart);
                else inStock.add(cart);
            }
            return new CartStatus(outOfStock, inStock);
        }catch (Exception e){
            throw new CartException(e.getMessage(), "CART_EXCEPTION", HttpStatus.BAD_REQUEST);
        }
    }
}
