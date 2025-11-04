package com.kdedevelop.mediani.application.tag.port.in.usecase;

import com.kdedevelop.mediani.application.tag.port.in.command.TagReadCommand;
import com.kdedevelop.mediani.domain.Tag;

public interface TagReadUseCase {
    Tag read(TagReadCommand command);
}
