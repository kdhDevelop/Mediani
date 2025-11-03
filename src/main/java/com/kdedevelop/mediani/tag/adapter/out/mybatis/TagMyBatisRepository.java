package com.kdedevelop.mediani.tag.adapter.out.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TagMyBatisRepository {
    void create(@Param("tag") TagMyBatisEntity entity);
    Optional<TagMyBatisEntity> readById(@Param("id") long id);
    Optional<TagMyBatisEntity> readByName(@Param("name") String name);
    Optional<TagMyBatisEntity> readFirstByOrderByIdDesc();
    List<TagMyBatisEntity> readByNameContaining(@Param("name") String name, @Param("page") Pageable pageable);
    long countAll();
    void update(@Param("tag") TagMyBatisEntity entity);
    void delete(@Param("id") long id);
}
