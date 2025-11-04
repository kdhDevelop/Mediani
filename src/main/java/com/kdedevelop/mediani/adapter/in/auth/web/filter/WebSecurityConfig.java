package com.kdedevelop.mediani.adapter.in.auth.web.filter;

import com.kdedevelop.mediani.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain (
            @Autowired HttpSecurity httpSecurity,
            @Autowired AuthenticationEntryPoint unauthenticationEntryPoint,
            @Autowired AccessDeniedHandler accessDeniedHandler,
            @Autowired AuthenticationSuccessHandler authenticationSuccessHandler,
            @Autowired LogoutSuccessHandler logoutSuccessHandler,
            @Autowired AuthenticationFailureHandler authenticationFailureHandler,
            @Autowired SecurityContextRepository securityContextRepository,
            @Autowired SessionRegistry sessionRegistry
    ) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .securityContext((securityContext) -> securityContext.securityContextRepository(securityContextRepository))
                .authorizeHttpRequests(
                        (authorizeHttpRequests) -> authorizeHttpRequests
                                .requestMatchers("/static/**").permitAll()
                                .requestMatchers("/session-expired", "/login", "/logout/success", "/login/success", "/error").permitAll()
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/api/register/**").permitAll()
                                .requestMatchers("/favicon.ico", "/manifest.json", "/logo192.png", "/logo512.png", "/robots.txt").permitAll()
                                .requestMatchers("/api/admin/**", "/admin/**", "/admin", "/index-update").hasRole(User.Role.ADMIN.name())
                                .requestMatchers("/api/user/**", "/user/**", "/user").hasRole(User.Role.USER.name())
                                .requestMatchers("/api/bot/**", "/bot/**", "/bot").hasRole(User.Role.BOT.name())
                                .anyRequest().denyAll()
                )
                .exceptionHandling(
                        (exceptionHandling) -> exceptionHandling
                                .accessDeniedHandler(accessDeniedHandler)
                                .authenticationEntryPoint(unauthenticationEntryPoint)
                )
                .formLogin(
                        (login) -> login
                                .loginProcessingUrl("/api/v0/login")
                                .usernameParameter("loginId")
                                .passwordParameter("password")
                                .successHandler(authenticationSuccessHandler)
                                .failureHandler(authenticationFailureHandler)
                                .permitAll()
                )
                .logout(
                        (logout) -> logout
                                .logoutUrl("/api/v0/logout")
                                .logoutSuccessHandler(logoutSuccessHandler)
                                .deleteCookies("JSESSIONID")
                                .permitAll()
                )
                .sessionManagement(
                        (sessionManagement) -> sessionManagement
                                .maximumSessions(1)
                                .maxSessionsPreventsLogin(true)
                                .sessionRegistry(sessionRegistry)
                                .expiredUrl("/session-expired")
                );

        return httpSecurity.build();
    }
}
