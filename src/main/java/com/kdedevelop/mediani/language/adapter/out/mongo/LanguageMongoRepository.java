package com.kdedevelop.mediani.language.adapter.out.mongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LanguageMongoRepository extends MongoRepository<LanguageMongoEntity, Short> {
    Optional<com.kdedevelop.mediani.language.adapter.out.mongo.LanguageMongoEntity> findFirstByOrderByIdDesc();
    Page<LanguageMongoEntity> findByNameContaining(String name, Pageable pageable);
}
