package com.subhajit.Medicare.Controllers.API.User.Order;

import com.subhajit.Medicare.Models.Address;
import com.subhajit.Medicare.Models.DTO.Cart;
import com.subhajit.Medicare.Models.DTO.Order;
import com.subhajit.Medicare.Models.OrderSummary;
import com.subhajit.Medicare.Payload.request.OrderRequest;
import com.subhajit.Medicare.Payload.response.MessageResponse;
import com.subhajit.Medicare.Services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    OrderService orderService;

    //    order product
    @PostMapping("/order")
    public ResponseEntity<MessageResponse> orderItem(@Valid @RequestBody OrderRequest orderRequest) {
        MessageResponse messageResponse = orderService.orderItem(orderRequest);
        return ResponseEntity.ok(messageResponse);
    }
    @PostMapping("/addAddress")
    public ResponseEntity<MessageResponse> addAddress(@Valid @RequestBody Address addressRequest){
        MessageResponse messageResponse=orderService.addAddresses(addressRequest);
        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
    }
    @PutMapping("/updateAddress")
    public ResponseEntity<MessageResponse> updateAddress(@Valid @RequestBody Address addressRequest){
        MessageResponse messageResponse=orderService.updateAddress(addressRequest);
        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }
    @GetMapping("/address/{userId}")
    public ResponseEntity<List<Address>> getAddress(@Valid String userId) {
       return new ResponseEntity<>(orderService.getAddress(userId), HttpStatus.OK);
    }
    //    order history
    @GetMapping("/showOrder/{userId}")
    public ResponseEntity<List<Order>> showOrder(@Valid @PathVariable String userId) {
        return ResponseEntity.ok(orderService.showOrder(userId));
    }
    @GetMapping("/orderSummary")
    public ResponseEntity<OrderSummary> getOrderSummary(@Valid @RequestBody List<Cart> carts ,@RequestBody Address address) {
        return ResponseEntity.ok(orderService.getOrderSummary(carts, address));
    }
    @PostMapping("/orderCart")
    public ResponseEntity<?> orderCart(@Valid @RequestBody OrderSummary orderSummary, @RequestParam String paymentType)
    {
        return new ResponseEntity<>(orderService.orderCart(orderSummary, paymentType),HttpStatus.OK);
    }
}
