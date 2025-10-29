package com.kdedevelop.mediani.type.application.port.in.usecase;

import com.kdedevelop.mediani.type.application.port.in.command.TypeReadCommand;
import com.kdedevelop.mediani.type.domain.Type;

public interface TypeReadUseCase {
    Type read(TypeReadCommand command);
}
