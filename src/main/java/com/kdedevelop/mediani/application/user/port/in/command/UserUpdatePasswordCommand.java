package com.kdedevelop.mediani.application.user.port.in.command;

import com.kdedevelop.mediani.common.StringUtils;

public record UserUpdatePasswordCommand(int id, String oldPassword, String newPassword, String confirmPassword) {
    public UserUpdatePasswordCommand {
        StringUtils.isPasswordValid(newPassword);
        if (!newPassword.equals(confirmPassword)) throw new IllegalArgumentException("new password and confirm password must be equals");
    }
}
