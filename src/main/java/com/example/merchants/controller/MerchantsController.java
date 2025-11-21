package com.example.merchants.controller;

import com.example.merchants.entity.Merchants;
import com.example.merchants.service.MerchantsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/merchants")
public class MerchantsController {

    private final MerchantsService service;

    public MerchantsController(MerchantsService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Merchants m) {
        Merchants saved = service.create(m);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Integer id) {
        Merchants m = service.get(id);
        if(m==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(m);
    }

    @PutMapping("/{id}/audit")
    public ResponseEntity audit(@PathVariable Integer id, @RequestParam boolean pass) {
        Merchants m = service.audit(id, pass);
        if(m==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(m);
    }
}
