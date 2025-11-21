package com.example.merchants.repository;
import com.example.merchants.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrdersRepository extends JpaRepository<Orders,Integer> {
}
