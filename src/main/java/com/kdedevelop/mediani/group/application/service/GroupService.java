package com.kdedevelop.mediani.group.application.service;

import com.kdedevelop.mediani.group.application.port.in.command.GroupCreateCommand;
import com.kdedevelop.mediani.group.application.port.in.command.GroupReadCommand;
import com.kdedevelop.mediani.group.application.port.in.command.GroupSearchByNameContainedCommand;
import com.kdedevelop.mediani.group.application.port.in.command.GroupUpdateCommand;
import com.kdedevelop.mediani.group.application.port.in.usecase.GroupCreateUseCase;
import com.kdedevelop.mediani.group.application.port.in.usecase.GroupReadUseCase;
import com.kdedevelop.mediani.group.application.port.in.usecase.GroupSearchByNameContainedUseCase;
import com.kdedevelop.mediani.group.application.port.in.usecase.GroupUpdateUseCase;
import com.kdedevelop.mediani.group.application.port.out.*;
import com.kdedevelop.mediani.group.domain.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService implements GroupCreateUseCase, GroupReadUseCase, GroupSearchByNameContainedUseCase, GroupUpdateUseCase {
    private final GroupCreatePort groupCreatePort;
    private final GroupGenerateIdPort groupGenerateIdPort;
    private final GroupReadPort groupReadPort;
    private final GroupSearchByNameContainedPort groupSearchByNameContainedPort;
    private final GroupUpdatePort groupUpdatePort;


    @Override
    public void create(GroupCreateCommand command) {
        Group group = new Group(groupGenerateIdPort.generateId(), command.name());
        groupCreatePort.create(group);
    }

    @Override
    public Group read(GroupReadCommand command) {
        return groupReadPort.read(command.id());
    }

    @Override
    public Page<Group> searchGroupByNameContained(GroupSearchByNameContainedCommand command, Pageable pageable) {
        return groupSearchByNameContainedPort.searchGroupByNameContained(command.name(), pageable);
    }

    @Override
    public void update(GroupUpdateCommand command) {
        Group group = groupReadPort.read(command.id());
        group.update(command.name());
        groupUpdatePort.update(group);
    }
}
