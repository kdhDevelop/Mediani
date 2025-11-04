package com.kdedevelop.mediani.adapter.in.user.dto;

public record UserUpdatePasswordRequest(String oldPassword, String newPassword, String confirmPassword) {
    public UserUpdatePasswordRequest {
        if (oldPassword == null || oldPassword.isBlank()) throw new IllegalArgumentException("oldPassword cannot be null or empty");
        if (newPassword == null || newPassword.isBlank()) throw new IllegalArgumentException("newPassword cannot be null or empty");
        if (confirmPassword == null || confirmPassword.isBlank()) throw new IllegalArgumentException("confirmPassword cannot be null or empty");
    }
}
