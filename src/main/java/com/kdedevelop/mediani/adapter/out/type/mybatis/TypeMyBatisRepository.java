package com.kdedevelop.mediani.adapter.out.type.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TypeMyBatisRepository {
    void create(@Param("type") TypeMyBatisEntity entity);
    Optional<TypeMyBatisEntity> readById(@Param("id") short id);
    Optional<TypeMyBatisEntity> readByName(@Param("name") String name);
    Optional<TypeMyBatisEntity> readFirstByOrderByIdDesc();
    List<TypeMyBatisEntity> readAll();
    List<TypeMyBatisEntity> readByNameContaining(@Param("name") String name, @Param("page") Pageable pageable);
    short countAll();
    void update(@Param("type") TypeMyBatisEntity entity);
    void delete(@Param("id") short id);
}
