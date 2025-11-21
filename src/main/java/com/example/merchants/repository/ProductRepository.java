package com.example.merchants.repository;
import com.example.merchants.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByIsActiveTrue();
}
