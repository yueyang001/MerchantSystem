package com.example.merchants.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id @GeneratedValue private Integer id;
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private Double price;
}
