package com.kdedevelop.mediani.application.user.port.in.usecase;

import com.kdedevelop.mediani.application.user.port.in.command.UserUpdateExpiredAtCommand;

public interface UserUpdateExpiredAtUseCase {
    void updateExpiredAt(UserUpdateExpiredAtCommand command);
}
