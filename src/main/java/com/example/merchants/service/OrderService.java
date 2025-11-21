package com.example.merchants.service;

import com.example.merchants.entity.OrderItem;
import com.example.merchants.entity.Orders;
import com.example.merchants.repository.OrderItemRepository;
import com.example.merchants.repository.OrdersRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrdersRepository ordersRepo;
    private final OrderItemRepository itemRepo;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderService(OrdersRepository ordersRepo, OrderItemRepository itemRepo, KafkaTemplate<String, String> kafkaTemplate) {
        this.ordersRepo = ordersRepo;
        this.itemRepo = itemRepo;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Orders createOrder(Orders o, List<OrderItem> items) {
        o.setStatus("CREATED");
        Orders saved = ordersRepo.save(o);
        for (OrderItem it : items) {
            it.setOrderId(saved.getId());
            itemRepo.save(it);
        }
        kafkaTemplate.send("orders", String.valueOf(saved.getId()));
        return saved;
    }
}
