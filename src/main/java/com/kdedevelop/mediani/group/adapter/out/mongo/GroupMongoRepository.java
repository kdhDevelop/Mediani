package com.kdedevelop.mediani.group.adapter.out.mongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface GroupMongoRepository extends MongoRepository<com.kdedevelop.mediani.group.adapter.out.mongo.GroupMongoEntity, Long> {
    Optional<com.kdedevelop.mediani.group.adapter.out.mongo.GroupMongoEntity> findFirstByOrderByIdDesc();
    Page<GroupMongoEntity> findByNameContaining(String name, Pageable pageable);
}
