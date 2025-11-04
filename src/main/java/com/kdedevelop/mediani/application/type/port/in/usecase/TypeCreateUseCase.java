package com.kdedevelop.mediani.application.type.port.in.usecase;

import com.kdedevelop.mediani.application.type.port.in.command.TypeCreateCommand;

public interface TypeCreateUseCase {
    void create(TypeCreateCommand command);
}
