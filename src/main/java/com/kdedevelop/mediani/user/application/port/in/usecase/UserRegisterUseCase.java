package com.kdedevelop.mediani.user.application.port.in.usecase;

import com.kdedevelop.mediani.user.application.port.in.command.UserRegisterCommand;

public interface UserRegisterUseCase {
    void register(UserRegisterCommand command);
}
