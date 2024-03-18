package com.subhajit.Medicare.Models;

import com.subhajit.Medicare.Models.DTO.Order;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class OrderSummary {
    private List<Order> items ;
    private double totalPrice;
    private double discount;
    private double payablePrice;

    public OrderSummary(List<Order> items, double totalPrice, double discount, double payablePrice) {
        this.items = items;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.payablePrice = payablePrice;
    }
}
