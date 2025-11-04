package com.kdedevelop.mediani.application.creator.port.in.usecase;

import com.kdedevelop.mediani.application.creator.port.in.command.CreatorReadCommand;
import com.kdedevelop.mediani.domain.Creator;

public interface CreatorReadUseCase {
    Creator read(CreatorReadCommand command);
}
