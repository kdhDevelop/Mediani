package com.kdedevelop.mediani.application.type.port.in.usecase;

import com.kdedevelop.mediani.application.type.port.in.command.TypeReadOrCreateByNameCommand;
import com.kdedevelop.mediani.domain.Type;

public interface TypeReadOrCreateByNameUseCase {
    Type readOrCreateByName(TypeReadOrCreateByNameCommand command);
}
