package com.example.merchants.controller;

import com.example.merchants.entity.CartItem;
import com.example.merchants.repository.CartItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {

    private final CartItemRepository cartRepo;

    public CartController(CartItemRepository cartRepo) {
        this.cartRepo = cartRepo;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody CartItem item) {
        return ResponseEntity.ok(cartRepo.save(item));
    }

    @GetMapping
    public ResponseEntity list(@RequestParam Integer userId) {
        List<CartItem> items = cartRepo.findByUserId(userId);
        return ResponseEntity.ok(items);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){ cartRepo.deleteById(id); return ResponseEntity.ok().build(); }
}
