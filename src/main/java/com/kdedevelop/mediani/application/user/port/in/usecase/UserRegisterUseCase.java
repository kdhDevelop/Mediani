package com.kdedevelop.mediani.application.user.port.in.usecase;

import com.kdedevelop.mediani.application.user.port.in.command.UserRegisterCommand;

public interface UserRegisterUseCase {
    void register(UserRegisterCommand command);
}
