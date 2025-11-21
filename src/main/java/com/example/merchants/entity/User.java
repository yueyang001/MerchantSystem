package com.example.merchants.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue private Integer id;
    @Column(unique = true, nullable = false) private String username;
    @Column(nullable = false) private String password;
    @Column(nullable = false) private String role;
}
