package com.kdedevelop.mediani.tag.application.service;

import com.kdedevelop.mediani.common.EntityNotFoundException;
import com.kdedevelop.mediani.tag.application.port.in.command.TagCreateCommand;
import com.kdedevelop.mediani.tag.application.port.in.command.TagReadOrCreateByNameCommand;
import com.kdedevelop.mediani.tag.application.port.in.command.TagUpdateCommand;
import com.kdedevelop.mediani.tag.application.port.in.usecase.*;
import com.kdedevelop.mediani.tag.application.port.out.*;
import com.kdedevelop.mediani.tag.domain.Tag;
import com.kdedevelop.mediani.type.application.port.in.command.TypeReadCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagService implements TagCreateUseCase, TagReadUseCase, TagSearchByNameContainedUseCase, TagUpdateUseCase, TagReadOrCreateByNameUseCase {
    private final TagCreatePort tagCreatePort;
    private final TagReadByIdPort tagReadByIdPort;
    private final TagGenerateIdPort tagGenerateIdPort;
    private final TagSearchByNameContainedPort tagSearchByNameContainedPort;
    private final TagUpdatePort tagUpdatePort;
    private final TagReadByNamePort tagReadByNamePort;

    @Override
    @Transactional
    public void create(TagCreateCommand command) {
        Tag tag = new Tag(tagGenerateIdPort.generateId(), command.name());
        tagCreatePort.create(tag);
    }

    @Override
    @Transactional(readOnly = true)
    public Tag read(TypeReadCommand command) {
        return tagReadByIdPort.read(command.id()).orElseThrow(() -> new EntityNotFoundException("tag id : " + command.id() + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Tag> searchByNameContained(String name, Pageable pageable) {
        return tagSearchByNameContainedPort.readByNameContained(name, pageable);
    }

    @Override
    @Transactional
    public void update(TagUpdateCommand command) {
        Tag tag = tagReadByIdPort.read(command.id()).orElseThrow(() -> new EntityNotFoundException("tag id : " + command.id() + " not found"));
        tag.update(command.name());
        tagUpdatePort.update(tag);
    }

    @Override
    @Transactional
    public Tag readOrCreateByName(TagReadOrCreateByNameCommand command) {
        Optional<Tag> tag = tagReadByNamePort.readByName(command.name());
        if (tag.isEmpty()) {
            try {
                tagCreatePort.create(new Tag(tagGenerateIdPort.generateId(), command.name()));
            } catch (Exception ignore) {}
            tag = tagReadByNamePort.readByName(command.name());
        }
        return tag.orElseThrow(() -> new IllegalStateException("tag name : " + command.name() + " not found"));
    }
}
