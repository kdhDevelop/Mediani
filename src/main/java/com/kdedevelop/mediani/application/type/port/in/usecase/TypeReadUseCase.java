package com.kdedevelop.mediani.application.type.port.in.usecase;

import com.kdedevelop.mediani.application.type.port.in.command.TypeReadCommand;
import com.kdedevelop.mediani.domain.Type;

public interface TypeReadUseCase {
    Type read(TypeReadCommand command);
}
