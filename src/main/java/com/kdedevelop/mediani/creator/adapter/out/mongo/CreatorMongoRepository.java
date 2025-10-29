package com.kdedevelop.mediani.creator.adapter.out.mongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CreatorMongoRepository extends MongoRepository<com.kdedevelop.mediani.creator.adapter.out.mongo.CreatorMongoEntity, Long> {
    Optional<com.kdedevelop.mediani.creator.adapter.out.mongo.CreatorMongoEntity> findFirstByOrderByIdDesc();
    Page<CreatorMongoEntity> findByNameContaining(String name, Pageable pageable);
}
