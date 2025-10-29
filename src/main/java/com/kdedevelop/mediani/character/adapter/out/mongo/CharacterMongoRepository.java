package com.kdedevelop.mediani.character.adapter.out.mongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CharacterMongoRepository extends MongoRepository<CharacterMongoEntity, Long> {
    Optional<CharacterMongoEntity> findFirstByOrderByIdDesc();
    Page<CharacterMongoEntity> findByNameContaining(String name, Pageable pageable);
}
