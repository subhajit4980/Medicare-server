package com.subhajit.Medicare.Controllers.API.Order;

import com.subhajit.Medicare.Models.Order;
import com.subhajit.Medicare.Payload.request.OrderRequest;
import com.subhajit.Medicare.Payload.response.MessageResponse;
import com.subhajit.Medicare.Services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    //    order history
    @GetMapping("/showOrder/{userId}")
    public ResponseEntity<List<Order>> showOrder(@Valid @PathVariable String userId) {
        return ResponseEntity.ok(orderService.showOrder(userId));
    }
}
