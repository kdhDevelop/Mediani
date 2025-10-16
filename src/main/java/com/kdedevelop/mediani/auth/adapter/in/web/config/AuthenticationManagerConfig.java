package com.kdedevelop.mediani.auth.adapter.in.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class AuthenticationManagerConfig {
    @Bean
    public AuthenticationManager authenticationManager(@Autowired HttpSecurity httpSecurity, @Autowired AuthenticationProvider authenticationProvider) throws Exception {
        return httpSecurity
                .getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(authenticationProvider)
                .build();
    }
}
