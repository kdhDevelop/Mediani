package com.kdedevelop.mediani.application.user.port.in.usecase;

import com.kdedevelop.mediani.application.user.port.in.command.UserUpdatePasswordCommand;

public interface UserUpdatePasswordUseCase {
    void updatePassword(UserUpdatePasswordCommand command);
}
