package com.kdedevelop.mediani.creator.application.port.in.usecase;

import com.kdedevelop.mediani.creator.application.port.in.command.CreatorReadCommand;
import com.kdedevelop.mediani.creator.domain.Creator;

public interface CreatorReadUseCase {
    Creator read(CreatorReadCommand command);
}
