package com.kdedevelop.mediani.user.adapter.out.jpa;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserMongoRepository extends MongoRepository<UserMongoEntity, Integer> {
    Optional<UserMongoEntity> findTopByOrderByIdDesc();
    Optional<UserMongoEntity> findByLoginId(String loginId);
    boolean existsByLoginId(String loginId);
}
