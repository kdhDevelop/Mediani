package com.kdedevelop.mediani.tag.application.service;

import com.kdedevelop.mediani.tag.application.port.in.command.TagCreateCommand;
import com.kdedevelop.mediani.tag.application.port.in.command.TagUpdateCommand;
import com.kdedevelop.mediani.tag.application.port.in.usecase.*;
import com.kdedevelop.mediani.tag.application.port.out.*;
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
    private final TagGenerateIdPort tagGenerateIdPort;
    private final TagSearchByNameContainedPort tagSearchByNameContainedPort;
    private final TagUpdatePort tagUpdatePort;

    @Override
    public void create(TagCreateCommand command) {
        Tag tag = new Tag(tagGenerateIdPort.generateId(), command.name());
        tagCreatePort.create(tag);
    }

    @Override
    public Tag read(TypeReadCommand command) {
        return tagReadPort.read(command.id());
    }

    @Override
    public Page<Tag> searchByNameContained(String name, Pageable pageable) {
        return tagSearchByNameContainedPort.readByNameContained(name, pageable);
    }

    @Override
    public void update(TagUpdateCommand command) {
        Tag tag = tagReadPort.read(command.id());
        tag.update(command.name());
        tagUpdatePort.update(tag);
    }
}
