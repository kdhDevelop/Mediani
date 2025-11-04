package com.kdedevelop.mediani.adapter.out.producer;

import com.kdedevelop.mediani.application.producer.port.out.*;
import com.kdedevelop.mediani.adapter.out.producer.mapper.ProducerOutBoundMapper;
import com.kdedevelop.mediani.adapter.out.producer.mybatis.ProducerMyBatisEntity;
import com.kdedevelop.mediani.common.generator.LongIdGenerator;
import com.kdedevelop.mediani.adapter.out.producer.mybatis.ProducerMyBatisRepository;
import com.kdedevelop.mediani.domain.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProducerPersistenceAdapterById implements ProducerCreatePort, ProducerGenerateIdPort, ProducerReadByIdPort, ProducerReadByNamePort, ProducerSearchByNameContainedPort, ProducerUpdatePort {
    private final ProducerMyBatisRepository producerMyBatisRepository;
    private final LongIdGenerator idGenerator;

    public ProducerPersistenceAdapterById(@Autowired ProducerMyBatisRepository producerMyBatisRepository) {
        this.producerMyBatisRepository = producerMyBatisRepository;

        Optional<ProducerMyBatisEntity> entity = producerMyBatisRepository.readFirstByOrderByIdDesc();
        idGenerator = new LongIdGenerator(entity.isPresent() ? entity.get().getId() : -1);
    }

    @Override
    public void create(Producer producer) {
        ProducerMyBatisEntity entity = ProducerOutBoundMapper.toProducerMyBatisEntity(producer);
        producerMyBatisRepository.create(entity);
    }

    @Override
    public long generateId() {
        return idGenerator.generate();
    }

    @Override
    public Optional<Producer> readById(long id) {
        return producerMyBatisRepository.readById(id).map(ProducerOutBoundMapper::toProducer);
    }

    @Override
    public Optional<Producer> readByName(String name) {
        return producerMyBatisRepository.readByName(name).map(ProducerOutBoundMapper::toProducer);
    }

    @Override
    public Page<Producer> searchProducerByNameContained(String name, Pageable pageable) {
        long totalElementCount = producerMyBatisRepository.countAll();
        List<ProducerMyBatisEntity> result = producerMyBatisRepository.readByNameContaining(name, pageable);
        return new PageImpl<>(result.stream().map(ProducerOutBoundMapper::toProducer).toList(), pageable, totalElementCount);
    }

    @Override
    public void update(Producer producer) {
        ProducerMyBatisEntity entity = ProducerOutBoundMapper.toProducerMyBatisEntity(producer);
        producerMyBatisRepository.update(entity);
    }
}
