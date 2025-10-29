package com.kdedevelop.mediani.type.application.port.in.usecase;

import com.kdedevelop.mediani.type.application.port.in.command.TypeSearchByNameContainedCommand;
import com.kdedevelop.mediani.type.domain.Type;
import org.springframework.data.domain.Page;

public interface TypeSearchByNameContainedUseCase {
    Page<Type> searchByNameContained (TypeSearchByNameContainedCommand command);
}
