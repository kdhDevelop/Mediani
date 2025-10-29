package com.kdedevelop.mediani.tag.adapter.out.mapper;

import com.kdedevelop.mediani.tag.adapter.out.mongo.TagMongoEntity;
import com.kdedevelop.mediani.tag.domain.Tag;

public class TagOutBoundMapper {
    public static Tag toTag(TagMongoEntity tagMongoEntity) {
        return new Tag(tagMongoEntity.getId(), tagMongoEntity.getName());
    }

    public static TagMongoEntity toTagMongoEntity(Tag tag) {
        return new TagMongoEntity(tag.getId(), tag.getName());
    }
}
