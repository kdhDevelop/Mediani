package com.kdedevelop.mediani.creator.adapter.out.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CreatorMyBatisRepository {
    void create(@Param("creator") CreatorMyBatisEntity entity);
    Optional<CreatorMyBatisEntity> readById(@Param("id") long id);
    Optional<CreatorMyBatisEntity> readByName(@Param("name") String name);
    Optional<CreatorMyBatisEntity> readFirstByOrderByIdDesc();
    List<CreatorMyBatisEntity> readByNameContaining(@Param("name") String name, @Param("page") Pageable pageable);
    long countAll();
    void update(@Param("creator") CreatorMyBatisEntity entity);
    void delete(@Param("id") long id);
}
