package com.kdedevelop.mediani.application.creator.service;

import com.kdedevelop.mediani.application.creator.port.in.command.*;
import com.kdedevelop.mediani.application.creator.port.in.usecase.*;
import com.kdedevelop.mediani.application.creator.port.out.*;
import com.kdedevelop.mediani.domain.Creator;
import com.kdedevelop.mediani.common.EntityNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreatorService implements CreatorCreateUseCase, CreatorReadUseCase, CreatorSearchByNameContainedUseCase, CreatorUpdateUseCase, CreatorReadOrCreateByNameUseCase {
    private final CreatorCreatePort creatorCreatePort;
    private final CreatorGenerateIdPort creatorGenerateIdPort;
    private final CreatorReadByIdPort creatorReadByIdPort;
    private final CreatorSearchByNameContainedPort creatorSearchByNameContainedPort;
    private final CreatorUpdatePort creatorUpdatePort;
    private final CreatorReadByNamePort creatorReadByNamePort;


    @Override
    @Transactional
    public void create(CreatorCreateCommand command) {
        Creator creator = new Creator(creatorGenerateIdPort.generateId(), command.name());
        creatorCreatePort.create(creator);
    }

    @Override
    @Transactional(readOnly = true)
    public Creator read(CreatorReadCommand command) {
        return creatorReadByIdPort.readById(command.id()).orElseThrow(() -> new EntityNotFoundException("creator id : " + command.id() + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Creator> searchCreatorByNameContained(CreatorSearchByNameContainedCommand command, Pageable pageable) {
        return creatorSearchByNameContainedPort.searchCreatorByNameContained(command.name(), pageable);
    }

    @Override
    @Transactional
    public void update(CreatorUpdateCommand command) {
        Creator creator = creatorReadByIdPort.readById(command.id()).orElseThrow(() -> new EntityNotFoundException("creator id : " + command.id() + " not found"));
        creator.update(command.name());
        creatorUpdatePort.update(creator);
    }

    @Override
    @Transactional
    public Creator readOrCreateByName(CreatorReadOrCreateByNameCommand command) {
        Optional<Creator> creator = creatorReadByNamePort.readByName(command.name());
        if (creator.isEmpty()) {
            try {
                creatorCreatePort.create(new Creator(creatorGenerateIdPort.generateId(), command.name()));
            } catch (Exception ignore) {}
            creator = creatorReadByNamePort.readByName(command.name());
        }
        return creator.orElseThrow(() -> new IllegalStateException("creator name " + command.name() + " not found"));
    }

}
