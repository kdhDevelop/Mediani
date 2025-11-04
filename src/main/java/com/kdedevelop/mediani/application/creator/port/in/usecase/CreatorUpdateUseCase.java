package com.kdedevelop.mediani.application.creator.port.in.usecase;

import com.kdedevelop.mediani.application.creator.port.in.command.CreatorUpdateCommand;

public interface CreatorUpdateUseCase {
    void update(CreatorUpdateCommand command);
}
