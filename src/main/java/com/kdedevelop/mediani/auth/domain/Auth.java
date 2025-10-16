package com.kdedevelop.mediani.auth.domain;

import com.kdedevelop.mediani.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@AllArgsConstructor
public class Auth implements UserDetails {
    private final User user;

    private static GrantedAuthority makeRole(User.Role role) {
        return new SimpleGrantedAuthority("ROLE_" + role.name());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        switch (user.getRole()) {
            case ADMIN: authorityList.add(makeRole(User.Role.USER));
            case USER: authorityList.add(makeRole(User.Role.ADMIN));
        }
        return authorityList;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLoginId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !user.getExpiredAt().isBefore(LocalDateTime.now());
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.isLock();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isEnable();
    }
}
