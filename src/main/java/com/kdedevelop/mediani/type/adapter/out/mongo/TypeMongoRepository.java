package com.kdedevelop.mediani.type.adapter.out.mongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TypeMongoRepository extends MongoRepository<TypeMongoEntity, Short> {
    Optional<TypeMongoEntity> findFirstByOrderByIdDesc();
    Page<TypeMongoEntity> findByNameContaining(String name, Pageable pageable);
}
