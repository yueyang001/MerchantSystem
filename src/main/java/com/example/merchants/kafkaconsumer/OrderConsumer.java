package com.example.merchants.kafkaconsumer;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    private final RedisTemplate<String, Object> redisTemplate;

    public OrderConsumer(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @KafkaListener(topics = "orders", groupId = "merchants-group")
    public void handleOrder(String message) {
        System.out.println("[Kafka Consumer] Received order message: " + message);
        String key = "stock:1";
        try {
            Long v = redisTemplate.opsForValue().decrement(key);
            System.out.println("[Kafka Consumer] Decrement stock: " + key + " -> " + v);
        } catch (Exception ex) {
            System.err.println("[Kafka Consumer] Error updating stock: " + ex.getMessage());
        }
    }
}
