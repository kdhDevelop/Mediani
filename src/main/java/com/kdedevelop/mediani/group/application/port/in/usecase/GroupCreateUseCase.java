package com.kdedevelop.mediani.group.application.port.in.usecase;

import com.kdedevelop.mediani.group.application.port.in.command.GroupCreateCommand;

public interface GroupCreateUseCase {
    void create(GroupCreateCommand command);
}
