package com.kdedevelop.mediani.group.application.service;

import com.kdedevelop.mediani.common.EntityNotFoundException;
import com.kdedevelop.mediani.group.application.port.in.command.*;
import com.kdedevelop.mediani.group.application.port.in.usecase.*;
import com.kdedevelop.mediani.group.application.port.out.*;
import com.kdedevelop.mediani.group.domain.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService implements GroupCreateUseCase, GroupReadUseCase, GroupSearchByNameContainedUseCase, GroupUpdateUseCase, GroupReadOrCreateByNameUseCase {
    private final GroupCreatePort groupCreatePort;
    private final GroupGenerateIdPort groupGenerateIdPort;
    private final GroupReadByIdPort groupReadByIdPort;
    private final GroupSearchByNameContainedPort groupSearchByNameContainedPort;
    private final GroupUpdatePort groupUpdatePort;
    private final GroupReadByNamePort groupReadByNamePort;


    @Override
    @Transactional
    public void create(GroupCreateCommand command) {
        Group group = new Group(groupGenerateIdPort.generateId(), command.name());
        groupCreatePort.create(group);
    }

    @Override
    @Transactional(readOnly = true)
    public Group read(GroupReadCommand command) {
        return groupReadByIdPort.readById(command.id()).orElseThrow(() -> new EntityNotFoundException("group id : " + command.id() + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Group> searchGroupByNameContained(GroupSearchByNameContainedCommand command, Pageable pageable) {
        return groupSearchByNameContainedPort.searchGroupByNameContained(command.name(), pageable);
    }

    @Override
    @Transactional
    public void update(GroupUpdateCommand command) {
        Group group = groupReadByIdPort.readById(command.id()).orElseThrow(() -> new EntityNotFoundException("group id : " + command.id() + " not found"));
        group.update(command.name());
        groupUpdatePort.update(group);
    }

    @Override
    @Transactional
    public Group readOrCreateByName(GroupReadOrCreateByNameCommand command) {
        Optional<Group> group = groupReadByNamePort.readByName(command.name());
        if (group.isEmpty()) {
            try {
                groupCreatePort.create(new Group(groupGenerateIdPort.generateId(), command.name()));
            } catch (Exception ignore) {}
            group = groupReadByNamePort.readByName(command.name());
        }
        return group.orElseThrow(() -> new IllegalStateException("group name : " + command.name() + " not found"));
    }
}
