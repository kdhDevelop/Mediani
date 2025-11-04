package com.kdedevelop.mediani.application.user.port.in.usecase;

import com.kdedevelop.mediani.application.user.port.in.command.UserDeleteCommand;

public interface UserDeleteUseCase {
    void delete(UserDeleteCommand command);
}
