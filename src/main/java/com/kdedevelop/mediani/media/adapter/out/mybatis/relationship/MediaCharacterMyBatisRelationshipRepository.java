package com.kdedevelop.mediani.media.adapter.out.mybatis.relationship;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MediaCharacterMyBatisRelationshipRepository {
    @Getter
    @AllArgsConstructor
    class Key {
        private short TypeId;
        private long mediaId;
        private long characterId;
    }

    void create(@Param("key") Key entity);
    void createAll(@Param("key") List<Key> entity);
    void delete(@Param("key") Key entity);
}
