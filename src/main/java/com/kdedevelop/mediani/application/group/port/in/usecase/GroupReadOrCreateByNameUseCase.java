package com.kdedevelop.mediani.application.group.port.in.usecase;

import com.kdedevelop.mediani.application.group.port.in.command.GroupReadOrCreateByNameCommand;
import com.kdedevelop.mediani.domain.Group;

public interface GroupReadOrCreateByNameUseCase {
    Group readOrCreateByName(GroupReadOrCreateByNameCommand command);
}
