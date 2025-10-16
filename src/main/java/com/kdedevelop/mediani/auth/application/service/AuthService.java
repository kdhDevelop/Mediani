package com.kdedevelop.mediani.auth.application.service;

import com.kdedevelop.mediani.auth.domain.Auth;

import com.kdedevelop.mediani.user.application.port.out.UserFindByLoginIdPort;
import com.kdedevelop.mediani.user.domain.User;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    private final UserFindByLoginIdPort userFindByLoginIdPort;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFindByLoginIdPort.findByLoginId(username);
        return new Auth(user);
    }
}
