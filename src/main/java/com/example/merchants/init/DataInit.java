package com.example.merchants.init;

import com.example.merchants.entity.User;
import com.example.merchants.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInit {

    @Bean
    CommandLineRunner init(UserRepository userRepository, PasswordEncoder encoder, RedisTemplate<String, Object> redisTemplate) {
        return args -> {
            if(userRepository.findByUsername("admin") == null) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("admin123"));
                admin.setRole("ROLE_ADMIN");
                userRepository.save(admin);
                System.out.println("Created default admin/admin123");
            }
            redisTemplate.opsForValue().set("stock:1", "100");
            System.out.println("Seeded Redis stock:1 = 100");
        };
    }
}
