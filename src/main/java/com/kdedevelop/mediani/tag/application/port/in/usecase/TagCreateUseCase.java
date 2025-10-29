package com.kdedevelop.mediani.tag.application.port.in.usecase;

import com.kdedevelop.mediani.tag.application.port.in.command.TagCreateCommand;

public interface TagCreateUseCase {
    void create(TagCreateCommand command);
}
