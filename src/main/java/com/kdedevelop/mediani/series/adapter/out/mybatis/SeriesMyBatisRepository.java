package com.kdedevelop.mediani.series.adapter.out.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SeriesMyBatisRepository {
    void create(@Param("series") SeriesMyBatisEntity entity);
    Optional<SeriesMyBatisEntity> readById(@Param("id") long id);
    Optional<SeriesMyBatisEntity> readByName(@Param("name") String name);
    Optional<SeriesMyBatisEntity> readFirstByOrderByIdDesc();
    List<SeriesMyBatisEntity> readByNameContaining(@Param("name") String name, @Param("page") Pageable pageable);
    long countAll();
    void update(@Param("series") SeriesMyBatisEntity entity);
    void delete(@Param("id") long id);
}
