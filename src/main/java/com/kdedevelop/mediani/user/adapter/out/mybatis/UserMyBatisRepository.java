package com.kdedevelop.mediani.user.adapter.out.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserMyBatisRepository {
    void create(@Param("user") UserMyBatisEntity entity);
    Optional<UserMyBatisEntity> readFirstByOrderByIdDesc();
    Optional<UserMyBatisEntity> readById(@Param("id") int id);
    Optional<UserMyBatisEntity> readByLoginId(@Param("loginId") String loginId);
    boolean existsByLoginId(@Param("loginId") String loginId);
    void update(@Param("user") UserMyBatisEntity entity);
}
