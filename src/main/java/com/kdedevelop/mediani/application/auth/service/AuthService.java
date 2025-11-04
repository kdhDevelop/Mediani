package com.kdedevelop.mediani.application.auth.service;

import com.kdedevelop.mediani.domain.Auth;

import com.kdedevelop.mediani.application.user.port.out.UserReadByLoginIdPort;
import com.kdedevelop.mediani.domain.User;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    private final UserReadByLoginIdPort userReadByLoginIdPort;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userReadByLoginIdPort.readByLoginId(username);
        return new Auth(user);
    }
}
