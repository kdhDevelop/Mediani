package com.kdedevelop.mediani.application.type.service;

import com.kdedevelop.mediani.application.type.port.in.command.*;
import com.kdedevelop.mediani.application.type.port.in.usecase.*;
import com.kdedevelop.mediani.application.type.port.out.*;
import com.kdedevelop.mediani.domain.Type;
import com.kdedevelop.mediani.common.EntityNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TypeService implements TypeCreateUseCase, TypeReadUseCase, TypeReadOrCreateByNameUseCase, TypeSearchByNameContainedUseCase, TypeUpdateUseCase, TypeDeleteUseCase {

    private final TypeGenerateIdPort typeGenerateIdPort;
    private final TypeCreatePort typeCreatePort;
    private final TypeReadByIdPort typeReadByIdPort;
    private final TypeReadByNamePort typeReadByNamePort;
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
        return typeReadByIdPort.readById(command.id()).orElseThrow(() -> new EntityNotFoundException("type id : " + command.id() + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Type> searchByNameContained(TypeSearchByNameContainedCommand command) {
        return typeSearchByNameContainedPort.searchByNameContained(command.name(), command.pageable());
    }

    @Override
    @Transactional
    public void update(TypeUpdateCommand command) {
        Type type = typeReadByIdPort.readById(command.id()).orElseThrow(() -> new EntityNotFoundException("type id : " + command.id() + " not found"));
        type.update(command.name());
        typeUpdatePort.update(type);
    }

    @Override
    @Transactional
    public void delete(TypeDeleteCommand command) {
        typeDeletePort.delete(command.id());
    }

    @Override
    @Transactional
    public Type readOrCreateByName(TypeReadOrCreateByNameCommand command) {
        Optional<Type> type = typeReadByNamePort.readByName(command.name());
        if (type.isEmpty()) {
            try {
                typeCreatePort.create(new Type(typeGenerateIdPort.generateId(), command.name()));
            } catch (Exception ignore) {}
            type = typeReadByNamePort.readByName(command.name());
        }
        return type.orElseThrow(() -> new IllegalStateException("Type name : " + command.name() + "not found"));
    }
}
