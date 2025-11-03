package com.kdedevelop.mediani.type.application.port.in.usecase;

import com.kdedevelop.mediani.type.application.port.in.command.TypeReadOrCreateByNameCommand;
import com.kdedevelop.mediani.type.domain.Type;

public interface TypeReadOrCreateByNameUseCase {
    Type readOrCreateByName(TypeReadOrCreateByNameCommand command);
}
