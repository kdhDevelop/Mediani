package com.kdedevelop.mediani.group.application.port.in.usecase;

import com.kdedevelop.mediani.group.application.port.in.command.GroupUpdateCommand;

public interface GroupUpdateUseCase {
    void update(GroupUpdateCommand command);
}
