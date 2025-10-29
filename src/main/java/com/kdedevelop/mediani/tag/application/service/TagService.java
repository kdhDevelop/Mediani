package com.kdedevelop.mediani.tag.application.service;

import com.kdedevelop.mediani.tag.application.port.in.command.TagCreateCommand;
import com.kdedevelop.mediani.tag.application.port.in.command.TagUpdateCommand;
import com.kdedevelop.mediani.tag.application.port.in.usecase.*;
import com.kdedevelop.mediani.tag.application.port.out.TagCreatePort;
import com.kdedevelop.mediani.tag.application.port.out.TagReadPort;
import com.kdedevelop.mediani.tag.application.port.out.TagSearchByNameContainedPort;
import com.kdedevelop.mediani.tag.application.port.out.TagUpdatePort;
import com.kdedevelop.mediani.tag.domain.Tag;
import com.kdedevelop.mediani.type.application.port.in.command.TypeReadCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService implements TagCreateUseCase, TagReadUseCase, TagSearchByNameContainedUseCase, TagUpdateUseCase {
    private final TagCreatePort tagCreatePort;
    private final TagReadPort tagReadPort;
    private final TagSearchByNameContainedPort tagSearchByNameContainedPort;
    private final TagUpdatePort tagUpdatePort;

    @Override
    public void create(TagCreateCommand command) {

    }

    @Override
    public Tag read(TypeReadCommand command) {
        return null;
    }

    @Override
    public Page<Tag> searchByNameContained(String name, Pageable pageable) {
        return null;
    }

    @Override
    public void update(TagUpdateCommand command) {

    }
}
