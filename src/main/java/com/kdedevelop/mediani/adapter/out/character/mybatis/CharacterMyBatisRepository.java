package com.kdedevelop.mediani.adapter.out.character.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CharacterMyBatisRepository {
    void create(@Param("character") CharacterMyBatisEntity entity);
    Optional<CharacterMyBatisEntity> readById(@Param("id") long id);
    Optional<CharacterMyBatisEntity> readByName(@Param("name") String name);
    Optional<CharacterMyBatisEntity> readFirstByOrderByIdDesc();
    List<CharacterMyBatisEntity> readByNameContaining(@Param("name") String name, @Param("page") Pageable pageable);
    long countAll();
    void update(@Param("character") CharacterMyBatisEntity entity);
    void delete(@Param("id") long id);
}
