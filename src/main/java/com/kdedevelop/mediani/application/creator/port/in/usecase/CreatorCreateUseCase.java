package com.kdedevelop.mediani.application.creator.port.in.usecase;

import com.kdedevelop.mediani.application.creator.port.in.command.CreatorCreateCommand;

public interface CreatorCreateUseCase {
    void create(CreatorCreateCommand command);
}
