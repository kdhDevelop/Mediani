package com.kdedevelop.mediani.creator.application.port.in.usecase;

import com.kdedevelop.mediani.creator.application.port.in.command.CreatorUpdateCommand;

public interface CreatorUpdateUseCase {
    void update(CreatorUpdateCommand command);
}
