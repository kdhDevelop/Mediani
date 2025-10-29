package com.kdedevelop.mediani.tag.application.port.in.usecase;

import com.kdedevelop.mediani.tag.domain.Tag;
import com.kdedevelop.mediani.type.application.port.in.command.TypeReadCommand;

public interface TagReadUseCase {
    Tag read(TypeReadCommand command);
}
