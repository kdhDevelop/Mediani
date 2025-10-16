package com.kdedevelop.mediani.user.application.port.in.usecase;

import com.kdedevelop.mediani.user.application.port.in.command.UserUpdateExpiredAtCommand;

public interface UserUpdateExpiredAtUseCase {
    void updateExpiredAt(UserUpdateExpiredAtCommand command);
}
