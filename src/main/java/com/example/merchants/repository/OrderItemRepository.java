package com.example.merchants.repository;
import com.example.merchants.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {
    List<OrderItem> findByOrderId(Integer orderId);
}
