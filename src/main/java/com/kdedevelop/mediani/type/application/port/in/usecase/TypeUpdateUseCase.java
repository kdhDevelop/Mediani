package com.kdedevelop.mediani.type.application.port.in.usecase;

import com.kdedevelop.mediani.type.application.port.in.command.TypeUpdateCommand;

public interface TypeUpdateUseCase {
    void update(TypeUpdateCommand command);
}
