package com.kdedevelop.mediani.user.application.port.in.usecase;

import com.kdedevelop.mediani.user.application.port.in.command.UserUpdateRoleCommand;

public interface UserUpdateRoleUseCase {
    void updateRole(UserUpdateRoleCommand command);
}
