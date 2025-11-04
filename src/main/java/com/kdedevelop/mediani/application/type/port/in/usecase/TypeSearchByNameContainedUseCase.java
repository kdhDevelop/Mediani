package com.kdedevelop.mediani.application.type.port.in.usecase;

import com.kdedevelop.mediani.application.type.port.in.command.TypeSearchByNameContainedCommand;
import com.kdedevelop.mediani.domain.Type;
import org.springframework.data.domain.Page;

public interface TypeSearchByNameContainedUseCase {
    Page<Type> searchByNameContained (TypeSearchByNameContainedCommand command);
}
