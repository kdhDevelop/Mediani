package com.kdedevelop.mediani.tag.adapter.out;

import com.kdedevelop.mediani.common.EntityNotFoundException;
import com.kdedevelop.mediani.infrastructure.adapter.out.generator.LongIdGenerator;
import com.kdedevelop.mediani.tag.adapter.out.mapper.TagOutBoundMapper;
import com.kdedevelop.mediani.tag.adapter.out.mongo.*;
import com.kdedevelop.mediani.tag.application.port.out.*;
import com.kdedevelop.mediani.tag.domain.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TagPersistenceAdapter implements TagCreatePort, TagReadPort, TagSearchByNameContainedPort, TagUpdatePort, TagGenerateIdPort {
    private final LongIdGenerator idGenerator;
    private final TagMongoRepository tagMongoRepository;

    public TagPersistenceAdapter(@Autowired TagMongoRepository tagMongoRepository) {
        this.tagMongoRepository = tagMongoRepository;

        Optional<TagMongoEntity> entity = tagMongoRepository.findFirstByOrderByIdDesc();
        this.idGenerator = new LongIdGenerator(entity.isPresent() ? entity.get().getId() : -1);
    }

    @Override
    public void create(Tag tag) {
        TagMongoEntity entity = TagOutBoundMapper.toTagMongoEntity(tag);
        tagMongoRepository.save(entity);
    }

    @Override
    public Tag read(long id) {
        TagMongoEntity entity = tagMongoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("tag id " + id + " not found"));
        return TagOutBoundMapper.toTag(entity);
    }

    @Override
    public Page<Tag> readByNameContained(String name, Pageable pageable) {
        return tagMongoRepository.findByNameContaining(name, pageable).map(TagOutBoundMapper::toTag);
    }

    @Override
    public void update(Tag tag) {
        TagMongoEntity entity = TagOutBoundMapper.toTagMongoEntity(tag);
        tagMongoRepository.save(entity);
    }

    @Override
    public long generateId() {
        return idGenerator.generate();
    }
}
