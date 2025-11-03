package com.kdedevelop.mediani.group.application.port.in.usecase;

import com.kdedevelop.mediani.group.application.port.in.command.GroupReadOrCreateByNameCommand;
import com.kdedevelop.mediani.group.domain.Group;

public interface GroupReadOrCreateByNameUseCase {
    Group readOrCreateByName(GroupReadOrCreateByNameCommand command);
}
