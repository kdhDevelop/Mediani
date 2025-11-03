package com.kdedevelop.mediani.tag.adapter.out.mapper;

import com.kdedevelop.mediani.tag.adapter.out.mybatis.TagMyBatisEntity;
import com.kdedevelop.mediani.tag.domain.Tag;

public class TagOutBoundMapper {
    public static Tag toTag(TagMyBatisEntity tagMyBatisEntity) {
        return new Tag(tagMyBatisEntity.getId(), tagMyBatisEntity.getName());
    }

    public static TagMyBatisEntity toTagMyBatisEntity(Tag tag) {
        return new TagMyBatisEntity(tag.getId(), tag.getName());
    }
}
