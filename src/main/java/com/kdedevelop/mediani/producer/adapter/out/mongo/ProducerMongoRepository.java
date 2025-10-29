package com.kdedevelop.mediani.producer.adapter.out.mongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProducerMongoRepository extends MongoRepository<com.kdedevelop.mediani.producer.adapter.out.mongo.ProducerMongoEntity, Long> {
    Optional<com.kdedevelop.mediani.producer.adapter.out.mongo.ProducerMongoEntity> findFirstByOrderByIdDesc();
    Page<ProducerMongoEntity> findByNameContaining(String name, Pageable pageable);
}
