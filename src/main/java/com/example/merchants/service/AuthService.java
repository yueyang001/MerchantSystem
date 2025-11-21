package com.example.merchants.service;

import com.example.merchants.entity.User;
import com.example.merchants.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(String username, String password, String role) {
        User exists = userRepository.findByUsername(username);
        if (exists != null) return null;
        User u = new User();
        u.setUsername(username);
        u.setPassword(passwordEncoder.encode(password));
        u.setRole(role);
        return userRepository.save(u);
    }

    public User authenticate(String username, String rawPassword) {
        User u = userRepository.findByUsername(username);
        if (u == null) return null;
        if (passwordEncoder.matches(rawPassword, u.getPassword())) return u;
        return null;
    }
}
