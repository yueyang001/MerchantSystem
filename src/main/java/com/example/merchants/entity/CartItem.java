package com.example.merchants.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id @GeneratedValue private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer quantity;
}
