package com.kdedevelop.mediani.user.application.port.in.command;

import com.kdedevelop.mediani.user.domain.User;

public record UserUpdateRoleCommand(int id, User.Role role) {
}
