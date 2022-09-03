package org.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.repo.UserRepo;
import org.example.resolver.PostBodyArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public PostBodyArgumentResolver postBodyArgumentResolver(ObjectMapper objectMapper, UserRepo userRepo) {
        return new PostBodyArgumentResolver(userRepo, objectMapper);
    }

}
