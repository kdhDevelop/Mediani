package com.kdedevelop.mediani.type.application.port.in.usecase;

import com.kdedevelop.mediani.type.application.port.in.command.TypeCreateCommand;

public interface TypeCreateUseCase {
    void create(TypeCreateCommand command);
}
