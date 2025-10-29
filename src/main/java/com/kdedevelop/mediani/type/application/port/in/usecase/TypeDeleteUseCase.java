package com.kdedevelop.mediani.type.application.port.in.usecase;

import com.kdedevelop.mediani.type.application.port.in.command.TypeDeleteCommand;

public interface TypeDeleteUseCase {
    void delete(TypeDeleteCommand command);
}
