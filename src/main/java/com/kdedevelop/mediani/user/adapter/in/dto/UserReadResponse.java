package com.kdedevelop.mediani.user.adapter.in.dto;

import com.kdedevelop.mediani.user.domain.User;

import java.time.LocalDateTime;

public record UserReadResponse(int id, String loginId, String name, LocalDateTime expiredAt, LocalDateTime createdAt, LocalDateTime updatedAt, User.Role role) {
}
