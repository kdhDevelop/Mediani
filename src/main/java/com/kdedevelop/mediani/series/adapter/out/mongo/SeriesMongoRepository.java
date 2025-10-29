package com.kdedevelop.mediani.series.adapter.out.mongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SeriesMongoRepository extends MongoRepository<SeriesMongoEntity, Long> {
    Optional<SeriesMongoEntity> findFirstByOrderByIdDesc();
    Page<SeriesMongoEntity> findByNameContaining(String name, Pageable pageable);
}
