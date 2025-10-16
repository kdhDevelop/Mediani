package com.kdedevelop.mediani.user.application.port.in.usecase;

import com.kdedevelop.mediani.user.application.port.in.command.UserUpdatePasswordCommand;

public interface UserUpdatePasswordUseCase {
    void updatePassword(UserUpdatePasswordCommand command);
}
