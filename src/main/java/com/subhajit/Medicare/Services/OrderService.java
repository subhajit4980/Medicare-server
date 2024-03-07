package com.subhajit.Medicare.Services;

import com.subhajit.Medicare.Exceptions.CartException;
import com.subhajit.Medicare.Exceptions.ProductException;
import com.subhajit.Medicare.Exceptions.UserException;
import com.subhajit.Medicare.Models.Order;
import com.subhajit.Medicare.Models.Product;
import com.subhajit.Medicare.Payload.request.OrderRequest;
import com.subhajit.Medicare.Payload.response.MessageResponse;
import com.subhajit.Medicare.Repository.CartRepository;
import com.subhajit.Medicare.Repository.OrderRepository;
import com.subhajit.Medicare.Repository.ProductRepository;
import com.subhajit.Medicare.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
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
    CartRepository cartRepository;

    public MessageResponse orderItem(OrderRequest orderRequest) {
        Product item = productRepository.findByItemId(orderRequest.getItemId()).orElseThrow(() -> new ProductException("item Not Found with", "NOT_FOUND", HttpStatus.NOT_FOUND));
        if (item.getQuantityInStock() == 0) {
            return new MessageResponse("item out of stock");
        }
        if (userRepository.existsByEmail(orderRequest.getEmail())) {
            Order order = new Order(orderRequest.getItemId(),
                    orderRequest.getNoOfQuantityToBuy(),
                    orderRequest.getEmail(),
                    orderRequest.getAddress(),
                    orderRequest.getPinNumber(),
                    orderRequest.getMobileNumber(),
                    "Pending",
                    LocalDate.now().toString(),
                    LocalDate.now().plusDays(4).toString(),
                    item.getPrice() * orderRequest.getNoOfQuantityToBuy(),
                    item.getImageUrl());
            order.setPaymentType(orderRequest.getPaymentType());
            if (item.getQuantityInStock() >= orderRequest.getNoOfQuantityToBuy()) {
                // Update the item with the new quantity
                item.setQuantityInStock(item.getQuantityInStock() - orderRequest.getNoOfQuantityToBuy());
            } else {
                throw new ProductException("Available quantity of " + item.getName() + " is " + item.getQuantityInStock(), "PRODUCT_NOT_AVAILABLE",HttpStatus.NOT_ACCEPTABLE);
            }
            if (orderRequest.getPaymentType().equals("ONLINE")) {
//                TODO Payment method call
            }
            // Save the updated item object
            productRepository.save(item);
            orderRepository.save(order);
            return new MessageResponse("item ordered successfully");
        } else throw new UserException("email not found", "INVALID_EMAIL",HttpStatus.NOT_ACCEPTABLE);
    }

    public List<Order> showOrder(String userId) {
        return orderRepository.findByUserId(userId);
    }
}
