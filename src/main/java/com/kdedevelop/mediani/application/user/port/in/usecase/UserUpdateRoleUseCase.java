package com.kdedevelop.mediani.application.user.port.in.usecase;

import com.kdedevelop.mediani.application.user.port.in.command.UserUpdateRoleCommand;

public interface UserUpdateRoleUseCase {
    void updateRole(UserUpdateRoleCommand command);
}
