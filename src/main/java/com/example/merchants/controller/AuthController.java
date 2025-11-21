package com.example.merchants.controller;

import com.example.merchants.entity.User;
import com.example.merchants.security.JwtUtil;
import com.example.merchants.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Map<String,String> body){
        String username = body.get("username");
        String password = body.get("password");
        String role = body.getOrDefault("role","ROLE_USER");
        User u = authService.register(username,password,role);
        if(u==null) return ResponseEntity.badRequest().body("username exists");
        Map<String,Object> res = new HashMap<>();
        res.put("id", u.getId());
        res.put("username", u.getUsername());
        return ResponseEntity.ok(res);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Map<String,String> body){
        String username = body.get("username");
        String password = body.get("password");
        User u = authService.authenticate(username,password);
        if(u==null) return ResponseEntity.status(401).body("invalid credentials");
        String token = jwtUtil.generateToken(u.getUsername(), u.getRole());
        Map<String,Object> res = new HashMap<>();
        res.put("token", token);
        res.put("role", u.getRole());
        return ResponseEntity.ok(res);
    }
}
