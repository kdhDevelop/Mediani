package com.kdedevelop.mediani.application.user.port.in.usecase;

import com.kdedevelop.mediani.application.user.port.in.command.UserUpdateLockStateCommand;

public interface UserUpdateLockStateUseCase {
    void updateLockState(UserUpdateLockStateCommand command);
}
