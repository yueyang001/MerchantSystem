package com.example.merchants.repository;
import com.example.merchants.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MerchantsRepository extends JpaRepository<Merchants,Integer> {
    Merchants findByName(String name);
}
