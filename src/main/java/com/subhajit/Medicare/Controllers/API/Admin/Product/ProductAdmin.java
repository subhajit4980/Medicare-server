package com.subhajit.Medicare.Controllers.API.Admin.Product;

import com.subhajit.Medicare.Models.DTO.Product;
import com.subhajit.Medicare.Payload.request.ProductRequest;
import com.subhajit.Medicare.Payload.response.MessageResponse;
import com.subhajit.Medicare.Services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Admin")
public class ProductAdmin {
    @Autowired
    ProductService productService;

    //add item to the database
    @PostMapping("/create")
    public ResponseEntity<MessageResponse> addItem(@Valid @RequestBody Product item) {
        MessageResponse messageResponse = productService.addItem(item);
        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
    }

    //update item data in database
    @PutMapping("/update")
    public ResponseEntity<MessageResponse> updateItem(@Valid @RequestBody ProductRequest item) {
        MessageResponse messageResponse=productService.updateItem(item);
        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }

    //    delete item from database
    @PutMapping("/delete")
    public ResponseEntity<MessageResponse> deleteItem(@Valid @RequestParam String itemId) {
        MessageResponse messageResponse=productService.deleteItem(itemId);
        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
//        return ResponseEntity.ok(new MessageResponse("deleitems"));
    }
}
