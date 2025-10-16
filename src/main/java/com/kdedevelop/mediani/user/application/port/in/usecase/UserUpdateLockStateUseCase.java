package com.kdedevelop.mediani.user.application.port.in.usecase;

import com.kdedevelop.mediani.user.application.port.in.command.UserUpdateLockStateCommand;

public interface UserUpdateLockStateUseCase {
    void updateLockState(UserUpdateLockStateCommand command);
}
