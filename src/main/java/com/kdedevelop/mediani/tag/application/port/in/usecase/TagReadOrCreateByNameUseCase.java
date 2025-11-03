package com.kdedevelop.mediani.tag.application.port.in.usecase;

import com.kdedevelop.mediani.tag.application.port.in.command.TagReadOrCreateByNameCommand;
import com.kdedevelop.mediani.tag.domain.Tag;

public interface TagReadOrCreateByNameUseCase {
    Tag readOrCreateByName(TagReadOrCreateByNameCommand command);
}
