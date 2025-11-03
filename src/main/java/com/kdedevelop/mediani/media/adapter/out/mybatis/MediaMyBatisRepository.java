package com.kdedevelop.mediani.media.adapter.out.mybatis;

import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MediaMyBatisRepository {
    void create(MediaMyBatisEntity entity);
    Optional<MediaMyBatisEntity> read(short typeId, long mediaId);
    void update(MediaMyBatisEntity entity);
    void delete(short typeId, long mediaId);
}
