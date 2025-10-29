package com.kdedevelop.mediani.type.application.service;

import com.kdedevelop.mediani.type.application.port.in.command.*;
import com.kdedevelop.mediani.type.application.port.in.usecase.*;
import com.kdedevelop.mediani.type.application.port.out.*;
import com.kdedevelop.mediani.type.domain.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TypeService implements TypeCreateUseCase, TypeReadUseCase, TypeSearchByNameContainedUseCase, TypeUpdateUseCase, TypeDeleteUseCase {

    private final TypeGenerateIdPort typeGenerateIdPort;
    private final TypeCreatePort typeCreatePort;
    private final TypeReadPort typeReadPort;
    private final TypeSearchByNameContainedPort typeSearchByNameContainedPort;
    private final TypeUpdatePort typeUpdatePort;
    private final TypeDeletePort typeDeletePort;

    @Override
    @Transactional
    public void create(TypeCreateCommand command) {
        Type type = new Type(typeGenerateIdPort.generateId(), command.name());
        typeCreatePort.create(type);
    }

    @Override
    @Transactional(readOnly = true)
    public Type read(TypeReadCommand command) {
        return typeReadPort.read(command.id());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Type> searchByNameContained(TypeSearchByNameContainedCommand command) {
        return typeSearchByNameContainedPort.searchByNameContained(command.name(), command.pageable());
    }

    @Override
    @Transactional
    public void update(TypeUpdateCommand command) {
        Type type = new Type(command.id(), command.name());
        typeUpdatePort.update(type);
    }

    @Override
    @Transactional
    public void delete(TypeDeleteCommand command) {
        typeDeletePort.delete(command.id());
    }
}
