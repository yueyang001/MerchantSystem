package com.example.merchants.controller;

import com.example.merchants.entity.Product;
import com.example.merchants.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service){ this.service = service; }
    @PostMapping
    public ResponseEntity create(@RequestBody Product p){ return ResponseEntity.ok(service.create(p)); }
    @GetMapping
    public ResponseEntity list(){ return ResponseEntity.ok(service.listActive()); }
}
