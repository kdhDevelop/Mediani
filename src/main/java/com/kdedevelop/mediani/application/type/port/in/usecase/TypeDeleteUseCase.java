package com.kdedevelop.mediani.application.type.port.in.usecase;

import com.kdedevelop.mediani.application.type.port.in.command.TypeDeleteCommand;

public interface TypeDeleteUseCase {
    void delete(TypeDeleteCommand command);
}
