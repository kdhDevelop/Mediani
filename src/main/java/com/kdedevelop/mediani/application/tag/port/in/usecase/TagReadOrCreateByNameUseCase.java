package com.kdedevelop.mediani.application.tag.port.in.usecase;

import com.kdedevelop.mediani.application.tag.port.in.command.TagReadOrCreateByNameCommand;
import com.kdedevelop.mediani.domain.Tag;

public interface TagReadOrCreateByNameUseCase {
    Tag readOrCreateByName(TagReadOrCreateByNameCommand command);
}
