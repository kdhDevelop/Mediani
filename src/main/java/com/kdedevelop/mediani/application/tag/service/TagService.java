package com.kdedevelop.mediani.application.tag.service;

import com.kdedevelop.mediani.application.tag.port.in.usecase.*;
import com.kdedevelop.mediani.application.tag.port.out.*;
import com.kdedevelop.mediani.application.tag.port.in.command.*;
import com.kdedevelop.mediani.domain.Tag;
import com.kdedevelop.mediani.common.EntityNotFoundException;

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
    public Tag read(TagReadCommand command) {
        return tagReadByIdPort.read(command.id()).orElseThrow(() -> new EntityNotFoundException("tag id : " + command.id() + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Tag> searchByNameContained(TagSearchByNameContainedCommand command, Pageable pageable) {
        return tagSearchByNameContainedPort.readByNameContained(command.name(), pageable);
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
