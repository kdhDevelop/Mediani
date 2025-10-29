package com.kdedevelop.mediani.group.application.port.in.usecase;

import com.kdedevelop.mediani.group.application.port.in.command.GroupReadCommand;
import com.kdedevelop.mediani.group.domain.Group;

public interface GroupReadUseCase {
    Group read(GroupReadCommand command);
}
