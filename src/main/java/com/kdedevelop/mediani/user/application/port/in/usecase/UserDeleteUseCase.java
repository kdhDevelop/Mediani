package com.kdedevelop.mediani.user.application.port.in.usecase;

import com.kdedevelop.mediani.user.application.port.in.command.UserDeleteCommand;

public interface UserDeleteUseCase {
    void delete(UserDeleteCommand command);
}
