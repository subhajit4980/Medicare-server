package com.subhajit.Medicare.Models;

import com.subhajit.Medicare.Models.DTO.Cart;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class CartSummary {
    private List<Cart> items;
    private double totalPrice;
    private double discount;
    private double payablePrice;

    public CartSummary(List<Cart> items, double totalPrice, double discount, double payablePrice) {
        this.items = items;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.payablePrice = payablePrice;
    }
}