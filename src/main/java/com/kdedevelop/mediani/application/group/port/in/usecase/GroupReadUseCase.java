package com.kdedevelop.mediani.application.group.port.in.usecase;

import com.kdedevelop.mediani.application.group.port.in.command.GroupReadCommand;
import com.kdedevelop.mediani.domain.Group;

public interface GroupReadUseCase {
    Group read(GroupReadCommand command);
}
