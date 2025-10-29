package com.kdedevelop.mediani.creator.application.port.in.usecase;

import com.kdedevelop.mediani.creator.application.port.in.command.CreatorCreateCommand;

public interface CreatorCreateUseCase {
    void create(CreatorCreateCommand command);
}
