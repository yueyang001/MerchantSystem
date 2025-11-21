package com.example.merchants.controller;

import com.example.merchants.entity.OrderItem;
import com.example.merchants.entity.Orders;
import com.example.merchants.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) { this.orderService = orderService; }

    @PostMapping
    public ResponseEntity create(@RequestBody Map<String,Object> body) {
        Integer userId = (Integer) body.get("userId");
        Double total = Double.valueOf(String.valueOf(body.get("total")));
        Orders o = new Orders();
        o.setUserId(userId);
        o.setTotal(total);
        List<Map<String,Object>> items = (List<Map<String,Object>>) body.get("items");
        List<OrderItem> orderItems = new java.util.ArrayList<>();
        for(Map<String,Object> it : items){
            OrderItem oi = new OrderItem();
            oi.setProductId((Integer) it.get("productId"));
            oi.setQuantity((Integer) it.get("quantity"));
            oi.setPrice(Double.valueOf(String.valueOf(it.get("price"))));
            orderItems.add(oi);
        }
        Orders saved = orderService.createOrder(o, orderItems);
        return ResponseEntity.ok(saved);
    }
}
