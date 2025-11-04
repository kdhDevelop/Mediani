package com.kdedevelop.mediani.application.tag.port.in.usecase;

import com.kdedevelop.mediani.application.tag.port.in.command.TagUpdateCommand;

public interface TagUpdateUseCase {
    void update(TagUpdateCommand command);
}
