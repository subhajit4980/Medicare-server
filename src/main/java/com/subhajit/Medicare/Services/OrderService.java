package com.subhajit.Medicare.Services;

import com.subhajit.Medicare.Exceptions.ProductException;
import com.subhajit.Medicare.Exceptions.UserException;
import com.subhajit.Medicare.Models.*;
import com.subhajit.Medicare.Models.DTO.Cart;
import com.subhajit.Medicare.Models.DTO.Order;
import com.subhajit.Medicare.Models.DTO.Product;
import com.subhajit.Medicare.Payload.request.OrderRequest;
import com.subhajit.Medicare.Payload.response.MessageResponse;
import com.subhajit.Medicare.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    AddressRepository addressRepository;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public OrderSummary getOrderSummary(List<Cart> carts, Address address) {
        List<Order> orders = new ArrayList<Order>();
        double totalPrice = 0.0;
        double discountPrice = 0.0;
        for (Cart cart : carts) {
            Product item = productRepository.findByItemId(cart.getItemId()).orElseThrow(() -> new ProductException("item Not Found with", "NOT_FOUND", HttpStatus.NOT_FOUND));
            Order order = new Order();
            order.setProductId(cart.getItemId());
            order.setOrderSpec(cart.getOrderSpec());
            order.setUserId(cart.getUserId());
            order.setOrderQuantity(cart.getNoOfQuantityToBuy());
            order.setAddress(address);
            order.setStatus("Pending");
            order.setOrderedDate(LocalDate.now().toString()); // Set the current date
            order.setExpectedDeliveryDate("Calculate based on business logic"); // You need to calculate this based on business logic
            order.setPrice(item.getPrice() * cart.getNoOfQuantityToBuy()); // You need to calculate this based on business logic
            order.setImageUrl(cart.getImageUrl());
            order.setPaymentStatus(false); // By default, payment status is set to false
            orders.add(order);
            totalPrice += item.getPrice();
            discountPrice += ((item.getPrice() * item.getDiscountPercentage()) / 100);
        }
        return new OrderSummary(orders, totalPrice, discountPrice, totalPrice - discountPrice);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public MessageResponse orderItem(OrderRequest orderRequest) {
        Product item = productRepository.findByItemId(orderRequest.getItemId()).orElseThrow(() -> new ProductException("item Not Found with", "NOT_FOUND", HttpStatus.NOT_FOUND));
        if (item.getQuantityInStock() == 0) {
            return new MessageResponse("item out of stock");
        }
        if (userRepository.existsById(orderRequest.getUserId())) {
            Order order = new Order(orderRequest.getItemId(),
                    orderRequest.getNoOfQuantityToBuy(),
                    orderRequest.getAddress(),
                    "Pending",
                    LocalDate.now().toString(),
                    LocalDate.now().plusDays(4).toString(),
                    item.getPrice() * orderRequest.getNoOfQuantityToBuy(),
                    item.getImageUrl().get(0));
            order.setUserId(orderRequest.getUserId());
            order.setPaymentType(orderRequest.getPaymentType());
            order.setOrderSpec(orderRequest.getOrderItemSpec());
            if (item.getQuantityInStock() >= orderRequest.getNoOfQuantityToBuy()) {
                // Update the item with the new quantity
                item.setQuantityInStock(item.getQuantityInStock() - orderRequest.getNoOfQuantityToBuy());
            } else {
                throw new ProductException("Available quantity of " + item.getName() + " is " + item.getQuantityInStock(), "PRODUCT_NOT_AVAILABLE", HttpStatus.NOT_ACCEPTABLE);
            }
            if (orderRequest.getPaymentType().equals("ONLINE")) {
//                TODO Payment method call
            } else if (orderRequest.getPaymentType().equals("COD")) {
                //  Save the updated item object
                productRepository.save(item);
                orderRepository.save(order);
            }
            return new MessageResponse("item ordered successfully");
        } else throw new UserException("email not found", "INVALID_EMAIL", HttpStatus.NOT_ACCEPTABLE);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public MessageResponse orderCart(OrderSummary orderSummary, String paymentType) {

        if (paymentType.equals("ONLINE")) {
            //                TODO Payment method call
        } else if (paymentType.equals("COD")) {
            List<Order> orders = new ArrayList<Order>();
            for (Order order : orderSummary.getItems()) {
                order.setPaymentType("COD");
                Product item = productRepository.findByItemId(order.getProductId()).orElseThrow(() -> new ProductException("item Not Found with", "NOT_FOUND", HttpStatus.NOT_FOUND));
                if (item.getQuantityInStock() >= order.getOrderQuantity()) {
                    // Update the item with the new quantity
                    item.setQuantityInStock(item.getQuantityInStock() - order.getOrderQuantity());
                    productRepository.save(item);
                    orderRepository.save(order);
                } else {
                    throw new ProductException("Available quantity of " + item.getName() + " is " + item.getQuantityInStock(), "PRODUCT_NOT_AVAILABLE", HttpStatus.NOT_ACCEPTABLE);
                }
            }
        }
        return new MessageResponse("Order placed successfully!");
    }

    public List<Order> showOrder(String userId) {
        return orderRepository.findByUserId(userId);
    }

    public MessageResponse addAddresses(Address address) {
        if (userRepository.existsById(address.getUserId())) {
            addressRepository.save(address);
            return new MessageResponse("Address saved successfully");
        } else throw new UserException("User not found", "USER_NOT_EXIST", HttpStatus.NOT_FOUND);
    }

    public synchronized MessageResponse updateAddress(Address address) {
        if (addressRepository.existsByAddressId(address.getAddressId())) {
            addressRepository.save(address);
            return new MessageResponse("Address updated successfully");
        } else throw new UserException("Address not found", "ADDRESS_NOT_EXIST", HttpStatus.NOT_FOUND);
    }

    public List<Address> getAddress(String userId) {
        if (userRepository.existsById(userId)) {
            return addressRepository.findByUserId(userId);
        } else throw new UserException("User not found", "USER_NOT_EXIST", HttpStatus.NOT_FOUND);
    }
}
