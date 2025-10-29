package com.kdedevelop.mediani.tag.application.port.in.usecase;

import com.kdedevelop.mediani.tag.application.port.in.command.TagUpdateCommand;

public interface TagUpdateUseCase {
    void update(TagUpdateCommand command);
}
