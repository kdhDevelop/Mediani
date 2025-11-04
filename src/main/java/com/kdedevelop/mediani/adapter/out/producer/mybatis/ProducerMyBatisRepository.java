package com.kdedevelop.mediani.adapter.out.producer.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProducerMyBatisRepository {
    void create(@Param("producer") ProducerMyBatisEntity entity);
    Optional<ProducerMyBatisEntity> readById(@Param("id") long id);
    Optional<ProducerMyBatisEntity> readByName(@Param("name") String name);
    Optional<ProducerMyBatisEntity> readFirstByOrderByIdDesc();
    List<ProducerMyBatisEntity> readByNameContaining(@Param("name") String name, @Param("page") Pageable pageable);
    long countAll();
    void update(@Param("producer") ProducerMyBatisEntity entity);
    void delete(@Param("id") long id);
}
