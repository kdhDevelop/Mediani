package com.kdedevelop.mediani.creator.application.port.in.usecase;

import com.kdedevelop.mediani.creator.application.port.in.command.CreatorReadOrCreateByNameCommand;
import com.kdedevelop.mediani.creator.domain.Creator;

public interface CreatorReadOrCreateByNameUseCase {
    Creator readOrCreateByName(CreatorReadOrCreateByNameCommand command);
}
