package com.kdedevelop.mediani.application.group.port.in.usecase;

import com.kdedevelop.mediani.application.group.port.in.command.GroupUpdateCommand;

public interface GroupUpdateUseCase {
    void update(GroupUpdateCommand command);
}
