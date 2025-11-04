package com.kdedevelop.mediani.application.user.port.in.command;

import com.kdedevelop.mediani.domain.User;

public record UserUpdateRoleCommand(int id, User.Role role) {
}
