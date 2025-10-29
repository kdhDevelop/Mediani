package com.kdedevelop.mediani.producer.adapter.out;

import com.kdedevelop.mediani.common.EntityNotFoundException;
import com.kdedevelop.mediani.infrastructure.adapter.out.generator.LongIdGenerator;
import com.kdedevelop.mediani.producer.adapter.out.mapper.ProducerOutBoundMapper;
import com.kdedevelop.mediani.producer.adapter.out.mongo.ProducerMongoEntity;
import com.kdedevelop.mediani.producer.adapter.out.mongo.ProducerMongoRepository;
import com.kdedevelop.mediani.producer.application.port.out.*;
import com.kdedevelop.mediani.producer.domain.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProducerPersistenceAdapter implements ProducerCreatePort, ProducerGenerateIdPort, ProducerReadPort, ProducerSearchByNameContainedPort, ProducerUpdatePort {
    private final ProducerMongoRepository producerMongoRepository;
    private final LongIdGenerator idGenerator;

    public ProducerPersistenceAdapter(@Autowired ProducerMongoRepository producerMongoRepository) {
        this.producerMongoRepository = producerMongoRepository;

        Optional<ProducerMongoEntity> entity = producerMongoRepository.findFirstByOrderByIdDesc();
        idGenerator = new LongIdGenerator(entity.isPresent() ? entity.get().getId() : -1);
    }

    @Override
    public void create(Producer producer) {
        ProducerMongoEntity entity = ProducerOutBoundMapper.toProducerMongoEntity(producer);
        producerMongoRepository.save(entity);
    }

    @Override
    public long generateId() {
        return idGenerator.generate();
    }

    @Override
    public Producer read(long id) {
        return ProducerOutBoundMapper.toProducer(producerMongoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("producer id : " + id + " not found")));
    }

    @Override
    public Page<Producer> searchProducerByNameContained(String name, Pageable pageable) {
        return producerMongoRepository.findByNameContaining(name, pageable).map(ProducerOutBoundMapper::toProducer);
    }

    @Override
    public void update(Producer producer) {
        ProducerMongoEntity entity = ProducerOutBoundMapper.toProducerMongoEntity(producer);
        producerMongoRepository.save(entity);
    }
}
