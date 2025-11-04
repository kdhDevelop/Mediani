package com.kdedevelop.mediani.adapter.out.group.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Mapper
public interface GroupMyBatisRepository {
    void create(@Param("group") GroupMyBatisEntity entity);
    Optional<GroupMyBatisEntity> readById(@Param("id") long id);
    Optional<GroupMyBatisEntity> readByName(@Param("name") String name);
    Optional<GroupMyBatisEntity> readFirstByOrderByIdDesc();
    List<GroupMyBatisEntity> readByNameContaining(@Param("name") String name, @Param("page") Pageable pageable);
    long countAll();
    void update(@Param("group") GroupMyBatisEntity entity);
    void delete(@Param("id") long id);
}
