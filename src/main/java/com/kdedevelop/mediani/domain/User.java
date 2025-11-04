package com.kdedevelop.mediani.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@ToString
public class User {
    public enum Role {
        ADMIN, USER, BOT
    }

    public User(int id, String loginId, String password, String name, LocalDateTime expiredAt, Role role) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.expiredAt = expiredAt;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.enable = true;
        this.lock = false;
        this.role = role;
    }

    private final int id;
    private final String loginId;
    private String password;
    private String name;
    private LocalDateTime expiredAt;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean lock;
    private boolean enable;
    private Role role;

    public void update(String name) {
        this.name = name;
        this.updatedAt = LocalDateTime.now();
    }

    public void updatePassword(String encodedPassword) {
        this.password = encodedPassword;
        this.updatedAt = LocalDateTime.now();
    }

    public void updateRole(Role role) {
        this.role = role;
        this.updatedAt = LocalDateTime.now();
    }

    public void updateExpiredAt(LocalDateTime expiredAt) {
        this.expiredAt = expiredAt;
    }

    public void updateLock(boolean lock) {
        this.lock = lock;
    }

    public void delete() {
        this.expiredAt = LocalDateTime.now();
        this.lock = true;
        this.enable = false;
    }
}
