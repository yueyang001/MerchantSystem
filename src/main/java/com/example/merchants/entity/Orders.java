package com.example.merchants.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "orders")
public class Orders {
    @Id @GeneratedValue private Integer id;
    private Integer userId;
    private Double total;
    private String status;
    private Date createdAt = new Date();
}
