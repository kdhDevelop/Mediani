package com.kdedevelop.mediani.adapter.in.user.dto;

import com.kdedevelop.mediani.domain.User;

import java.time.LocalDateTime;

public record UserReadResponse(int id, String loginId, String name, LocalDateTime expiredAt, LocalDateTime createdAt, LocalDateTime updatedAt, User.Role role) {
}
