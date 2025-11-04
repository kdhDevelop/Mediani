package com.kdedevelop.mediani.adapter.in.user.dto;

public record UserRegisterRequest(String loginId, String password, String name) {
    public UserRegisterRequest {
        if (loginId == null || loginId.isBlank()) throw new IllegalArgumentException("loginId cannot be null or empty");
        if (password == null || password.isBlank()) throw new IllegalArgumentException("password cannot be null or empty");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name cannot be null or empty");
    }
}
