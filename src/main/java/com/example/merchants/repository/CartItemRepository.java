package com.example.merchants.repository;
import com.example.merchants.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
    List<CartItem> findByUserId(Integer userId);
}
