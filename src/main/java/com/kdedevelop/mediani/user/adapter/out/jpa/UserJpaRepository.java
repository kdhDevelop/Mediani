package com.kdedevelop.mediani.user.adapter.out.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserJpaEntity, Integer> {
    Optional<UserJpaEntity> findTopByOrderByIdDesc();
    Optional<UserJpaEntity> findByLoginId(String loginId);
    boolean existsByLoginId(String loginId);
}
