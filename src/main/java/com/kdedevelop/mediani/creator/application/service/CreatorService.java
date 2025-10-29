package com.kdedevelop.mediani.creator.application.service;

import com.kdedevelop.mediani.creator.application.port.in.command.CreatorCreateCommand;
import com.kdedevelop.mediani.creator.application.port.in.command.CreatorReadCommand;
import com.kdedevelop.mediani.creator.application.port.in.command.CreatorSearchByNameContainedCommand;
import com.kdedevelop.mediani.creator.application.port.in.command.CreatorUpdateCommand;
import com.kdedevelop.mediani.creator.application.port.in.usecase.CreatorCreateUseCase;
import com.kdedevelop.mediani.creator.application.port.in.usecase.CreatorReadUseCase;
import com.kdedevelop.mediani.creator.application.port.in.usecase.CreatorSearchByNameContainedUseCase;
import com.kdedevelop.mediani.creator.application.port.in.usecase.CreatorUpdateUseCase;
import com.kdedevelop.mediani.creator.application.port.out.*;
import com.kdedevelop.mediani.creator.domain.Creator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatorService implements CreatorCreateUseCase, CreatorReadUseCase, CreatorSearchByNameContainedUseCase, CreatorUpdateUseCase {
    private final CreatorCreatePort creatorCreatePort;
    private final CreatorGenerateIdPort creatorGenerateIdPort;
    private final CreatorReadPort creatorReadPort;
    private final CreatorSearchByNameContainedPort creatorSearchByNameContainedPort;
    private final CreatorUpdatePort creatorUpdatePort;


    @Override
    public void create(CreatorCreateCommand command) {
        Creator creator = new Creator(creatorGenerateIdPort.generateId(), command.name());
        creatorCreatePort.create(creator);
    }

    @Override
    public Creator read(CreatorReadCommand command) {
        return creatorReadPort.read(command.id());
    }

    @Override
    public Page<Creator> searchCreatorByNameContained(CreatorSearchByNameContainedCommand command, Pageable pageable) {
        return creatorSearchByNameContainedPort.searchCreatorByNameContained(command.name(), pageable);
    }

    @Override
    public void update(CreatorUpdateCommand command) {
        Creator creator = creatorReadPort.read(command.id());
        creator.update(command.name());
        creatorUpdatePort.update(creator);
    }
}
