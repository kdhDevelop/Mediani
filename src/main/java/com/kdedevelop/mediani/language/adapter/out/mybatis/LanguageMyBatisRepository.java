package com.kdedevelop.mediani.language.adapter.out.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Mapper
public interface LanguageMyBatisRepository {
    void create(@Param("language") LanguageMyBatisEntity entity);
    Optional<LanguageMyBatisEntity> readById(@Param("id") short id);
    Optional<LanguageMyBatisEntity> readByName(@Param("name") String name);
    Optional<LanguageMyBatisEntity> readFirstByOrderByIdDesc();
    List<LanguageMyBatisEntity> readByNameContaining(@Param("name") String name, @Param("page") Pageable pageable);
    short countAll();
    void update(@Param("language") LanguageMyBatisEntity entity);
    void delete(@Param("id") short id);
}
