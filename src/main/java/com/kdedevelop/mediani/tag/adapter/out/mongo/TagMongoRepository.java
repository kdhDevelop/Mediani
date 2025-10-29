package com.kdedevelop.mediani.tag.adapter.out.mongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TagMongoRepository extends MongoRepository<TagMongoEntity, Long> {
    Optional<TagMongoEntity> findFirstByOrderByIdDesc();
    Page<TagMongoEntity> findByNameContaining(String name, Pageable pageable);
}
