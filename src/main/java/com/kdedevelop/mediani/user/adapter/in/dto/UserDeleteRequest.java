package com.kdedevelop.mediani.user.adapter.in.dto;

public record UserDeleteRequest(String password) {
    public UserDeleteRequest {
        if (password == null || password.isBlank()) throw new IllegalArgumentException("Password cannot be null or empty");
    }
}
