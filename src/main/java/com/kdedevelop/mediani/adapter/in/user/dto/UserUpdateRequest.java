package com.kdedevelop.mediani.adapter.in.user.dto;

public record UserUpdateRequest(String name) {
    public UserUpdateRequest {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name cannot be null or empty");
    }
}
