package com.kdedevelop.mediani.application.user.port.in.usecase;

import com.kdedevelop.mediani.application.user.port.in.command.UserUpdateCommand;

public interface UserUpdateUseCase {
    void update(UserUpdateCommand command);
}
