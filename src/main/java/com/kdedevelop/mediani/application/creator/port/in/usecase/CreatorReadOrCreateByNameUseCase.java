package com.kdedevelop.mediani.application.creator.port.in.usecase;

import com.kdedevelop.mediani.application.creator.port.in.command.CreatorReadOrCreateByNameCommand;
import com.kdedevelop.mediani.domain.Creator;

public interface CreatorReadOrCreateByNameUseCase {
    Creator readOrCreateByName(CreatorReadOrCreateByNameCommand command);
}
