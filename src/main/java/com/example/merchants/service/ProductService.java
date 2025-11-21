package com.example.merchants.service;

import com.example.merchants.entity.Product;
import com.example.merchants.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;
    public ProductService(ProductRepository repo){ this.repo = repo; }
    public Product create(Product p){ return repo.save(p); }
    public List<Product> listActive(){ return repo.findByIsActiveTrue(); }
    public Product get(Integer id){ return repo.findById(id).orElse(null); }
}
