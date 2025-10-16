package com.kdedevelop.mediani.user.application.port.in.usecase;

import com.kdedevelop.mediani.user.application.port.in.command.UserUpdateCommand;

public interface UserUpdateUseCase {
    void update(UserUpdateCommand command);
}
