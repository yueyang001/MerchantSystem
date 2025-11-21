package com.example.merchants.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id @GeneratedValue private Integer id;
    @Column(nullable = false) private String name;
    private String description;
    private Double price;
    @Column(nullable = false) private Integer stock;
    private Boolean isActive = true;
    private Integer merchantId;
}
