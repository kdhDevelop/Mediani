package com.kdedevelop.mediani.adapter.out.tag;

import com.kdedevelop.mediani.application.tag.port.out.*;
import com.kdedevelop.mediani.adapter.out.tag.mapper.TagOutBoundMapper;
import com.kdedevelop.mediani.adapter.out.tag.mybatis.TagMyBatisEntity;
import com.kdedevelop.mediani.common.generator.LongIdGenerator;
import com.kdedevelop.mediani.adapter.out.tag.mybatis.*;
import com.kdedevelop.mediani.domain.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TagPersistenceAdapterById implements TagCreatePort, TagReadByIdPort, TagReadByNamePort, TagSearchByNameContainedPort, TagUpdatePort, TagGenerateIdPort {
    private final LongIdGenerator idGenerator;
    private final TagMyBatisRepository tagMyBatisRepository;

    public TagPersistenceAdapterById(@Autowired TagMyBatisRepository tagMyBatisRepository) {
        this.tagMyBatisRepository = tagMyBatisRepository;

        Optional<TagMyBatisEntity> entity = tagMyBatisRepository.readFirstByOrderByIdDesc();
        this.idGenerator = new LongIdGenerator(entity.isPresent() ? entity.get().getId() : -1);
    }

    @Override
    public void create(Tag tag) {
        TagMyBatisEntity entity = TagOutBoundMapper.toTagMyBatisEntity(tag);
        tagMyBatisRepository.create(entity);
    }

    @Override
    public Optional<Tag> read(long id) {
        return tagMyBatisRepository.readById(id).map(TagOutBoundMapper::toTag);
    }

    @Override
    public Optional<Tag> readByName(String name) {
        return tagMyBatisRepository.readByName(name).map(TagOutBoundMapper::toTag);
    }

    @Override
    public Page<Tag> readByNameContained(String name, Pageable pageable) {
        long totalElementCount = tagMyBatisRepository.countAll();
        List<TagMyBatisEntity> result = tagMyBatisRepository.readByNameContaining(name, pageable);
        return new PageImpl<>(result.stream().map(TagOutBoundMapper::toTag).toList(), pageable, totalElementCount);
    }

    @Override
    public void update(Tag tag) {
        TagMyBatisEntity entity = TagOutBoundMapper.toTagMyBatisEntity(tag);
        tagMyBatisRepository.update(entity);
    }

    @Override
    public long generateId() {
        return idGenerator.generate();
    }
}
