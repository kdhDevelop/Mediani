package com.kdedevelop.mediani.application.type.port.in.usecase;

import com.kdedevelop.mediani.application.type.port.in.command.TypeUpdateCommand;

public interface TypeUpdateUseCase {
    void update(TypeUpdateCommand command);
}
