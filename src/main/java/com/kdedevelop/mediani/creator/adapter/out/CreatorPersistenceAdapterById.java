package com.kdedevelop.mediani.creator.adapter.out;

import com.kdedevelop.mediani.infrastructure.adapter.out.generator.LongIdGenerator;
import com.kdedevelop.mediani.creator.adapter.out.mapper.CreatorOutBoundMapper;
import com.kdedevelop.mediani.creator.adapter.out.mybatis.CreatorMyBatisEntity;
import com.kdedevelop.mediani.creator.adapter.out.mybatis.CreatorMyBatisRepository;
import com.kdedevelop.mediani.creator.application.port.out.*;
import com.kdedevelop.mediani.creator.domain.Creator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CreatorPersistenceAdapterById implements CreatorCreatePort, CreatorGenerateIdPort, CreatorReadByIdPort, CreatorReadByNamePort, CreatorSearchByNameContainedPort, CreatorUpdatePort {
    private final CreatorMyBatisRepository creatorMyBatisRepository;
    private final LongIdGenerator idGenerator;

    public CreatorPersistenceAdapterById(@Autowired CreatorMyBatisRepository creatorMyBatisRepository) {
        this.creatorMyBatisRepository = creatorMyBatisRepository;

        Optional<CreatorMyBatisEntity> entity = creatorMyBatisRepository.readFirstByOrderByIdDesc();
        idGenerator = new LongIdGenerator(entity.isPresent() ? entity.get().getId() : -1);
    }

    @Override
    public void create(Creator creator) {
        CreatorMyBatisEntity entity = CreatorOutBoundMapper.toCreatorMyBatisEntity(creator);
        creatorMyBatisRepository.create(entity);
    }

    @Override
    public long generateId() {
        return idGenerator.generate();
    }

    @Override
    public Optional<Creator> readById(long id) {
        return creatorMyBatisRepository.readById(id).map(CreatorOutBoundMapper::toCreator);
    }

    @Override
    public Optional<Creator> readByName(String name) {
        return creatorMyBatisRepository.readByName(name).map(CreatorOutBoundMapper::toCreator);
    }

    @Override
    public Page<Creator> searchCreatorByNameContained(String name, Pageable pageable) {
        long totalElement = creatorMyBatisRepository.countAll();
        List<CreatorMyBatisEntity> result = creatorMyBatisRepository.readByNameContaining(name, pageable);
        return new PageImpl<>(result.stream().map(CreatorOutBoundMapper::toCreator).toList(), pageable, totalElement);
    }

    @Override
    public void update(Creator creator) {
        CreatorMyBatisEntity entity = CreatorOutBoundMapper.toCreatorMyBatisEntity(creator);
        creatorMyBatisRepository.update(entity);
    }
}
