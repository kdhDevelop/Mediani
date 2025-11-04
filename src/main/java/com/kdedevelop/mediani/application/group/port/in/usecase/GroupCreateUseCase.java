package com.kdedevelop.mediani.application.group.port.in.usecase;

import com.kdedevelop.mediani.application.group.port.in.command.GroupCreateCommand;

public interface GroupCreateUseCase {
    void create(GroupCreateCommand command);
}
