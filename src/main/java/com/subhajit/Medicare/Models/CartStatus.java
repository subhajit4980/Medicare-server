package com.subhajit.Medicare.Models;

import com.subhajit.Medicare.Models.DTO.Cart;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class CartStatus {
    private List<Cart> inStock;
    private List<Cart> outOfStock;

    public CartStatus(List<Cart> inStock, List<Cart> outOfStock) {
        this.inStock = inStock;
        this.outOfStock = outOfStock;
    }
}