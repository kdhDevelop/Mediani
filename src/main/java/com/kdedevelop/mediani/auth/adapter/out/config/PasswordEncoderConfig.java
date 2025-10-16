package com.kdedevelop.mediani.auth.adapter.out.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {
    @Bean
    public PasswordEncoder passwordEncoder(@Value("${spring.security.secret}") String SECRET_KEY) {
        return new Pbkdf2PasswordEncoder(SECRET_KEY, 128, 65536, Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
    }
}
