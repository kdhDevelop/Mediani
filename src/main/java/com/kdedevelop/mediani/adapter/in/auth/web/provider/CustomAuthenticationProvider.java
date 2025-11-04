package com.kdedevelop.mediani.adapter.in.auth.web.provider;

import com.kdedevelop.mediani.common.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    @Override
    @Transactional(readOnly = true)
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String loginId = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginId);

        StringUtils.isLoginIdValid(loginId);

        if (!userDetails.isEnabled()) throw new IllegalArgumentException("account is disabled");
        if (!userDetails.isAccountNonExpired()) throw new IllegalArgumentException("account is expired");
        if (!userDetails.isCredentialsNonExpired()) throw new IllegalArgumentException("account password is expired");
        if (!passwordEncoder.matches(password, userDetails.getPassword())) throw new IllegalArgumentException("account password does not match");

        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
