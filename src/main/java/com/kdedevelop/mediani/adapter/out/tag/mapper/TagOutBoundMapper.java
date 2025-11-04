package com.kdedevelop.mediani.adapter.out.tag.mapper;

import com.kdedevelop.mediani.adapter.out.tag.mybatis.TagMyBatisEntity;
import com.kdedevelop.mediani.domain.Tag;

public class TagOutBoundMapper {
    public static Tag toTag(TagMyBatisEntity tagMyBatisEntity) {
        return new Tag(tagMyBatisEntity.getId(), tagMyBatisEntity.getName());
    }

    public static TagMyBatisEntity toTagMyBatisEntity(Tag tag) {
        return new TagMyBatisEntity(tag.getId(), tag.getName());
    }
}
