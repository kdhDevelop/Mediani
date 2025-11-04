package com.kdedevelop.mediani.application.tag.port.in.usecase;

import com.kdedevelop.mediani.application.tag.port.in.command.TagCreateCommand;

public interface TagCreateUseCase {
    void create(TagCreateCommand command);
}
