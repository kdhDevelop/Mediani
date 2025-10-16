package com.kdedevelop.mediani.user.application.port.in.command;

import com.kdedevelop.mediani.common.StringUtils;
import com.kdedevelop.mediani.user.domain.User;

import java.time.LocalDateTime;

public record UserRegisterCommand(
        String loginId,
        String password,
        String name,
        LocalDateTime expiredAt,
        User.Role role
) {
    public UserRegisterCommand {
        StringUtils.isLoginIdValid(loginId);
        StringUtils.isPasswordValid(password);
        if (expiredAt == null) expiredAt = LocalDateTime.now().plusDays(1);
        if (role == null) role = User.Role.USER;
    }
}
