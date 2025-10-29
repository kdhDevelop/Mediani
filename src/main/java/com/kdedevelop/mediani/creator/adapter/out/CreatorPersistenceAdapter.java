package com.kdedevelop.mediani.creator.adapter.out;

import com.kdedevelop.mediani.common.EntityNotFoundException;
import com.kdedevelop.mediani.infrastructure.adapter.out.generator.LongIdGenerator;
import com.kdedevelop.mediani.creator.adapter.out.mapper.CreatorOutBoundMapper;
import com.kdedevelop.mediani.creator.adapter.out.mongo.CreatorMongoEntity;
import com.kdedevelop.mediani.creator.adapter.out.mongo.CreatorMongoRepository;
import com.kdedevelop.mediani.creator.application.port.out.*;
import com.kdedevelop.mediani.creator.domain.Creator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CreatorPersistenceAdapter implements CreatorCreatePort, CreatorGenerateIdPort, CreatorReadPort, CreatorSearchByNameContainedPort, CreatorUpdatePort {
    private final CreatorMongoRepository creatorMongoRepository;
    private final LongIdGenerator idGenerator;

    public CreatorPersistenceAdapter(@Autowired CreatorMongoRepository creatorMongoRepository) {
        this.creatorMongoRepository = creatorMongoRepository;

        Optional<CreatorMongoEntity> entity = creatorMongoRepository.findFirstByOrderByIdDesc();
        idGenerator = new LongIdGenerator(entity.isPresent() ? entity.get().getId() : -1);
    }

    @Override
    public void create(Creator creator) {
        CreatorMongoEntity entity = CreatorOutBoundMapper.toCreatorMongoEntity(creator);
        creatorMongoRepository.save(entity);
    }

    @Override
    public long generateId() {
        return idGenerator.generate();
    }

    @Override
    public Creator read(long id) {
        return CreatorOutBoundMapper.toCreator(creatorMongoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("creator id : " + id + " not found")));
    }

    @Override
    public Page<Creator> searchCreatorByNameContained(String name, Pageable pageable) {
        return creatorMongoRepository.findByNameContaining(name, pageable).map(CreatorOutBoundMapper::toCreator);
    }

    @Override
    public void update(Creator creator) {
        CreatorMongoEntity entity = CreatorOutBoundMapper.toCreatorMongoEntity(creator);
        creatorMongoRepository.save(entity);
    }
}
