package com.kdedevelop.mediani.creator.adapter.out.mapper;

import com.kdedevelop.mediani.creator.adapter.out.mongo.CreatorMongoEntity;
import com.kdedevelop.mediani.creator.domain.Creator;

public class CreatorOutBoundMapper {
    public static Creator toCreator(CreatorMongoEntity creatorMongoEntity) {
        return new Creator(creatorMongoEntity.getId(), creatorMongoEntity.getName());
    }

    public static CreatorMongoEntity toCreatorMongoEntity(Creator creator) {
        return new CreatorMongoEntity(creator.getId(), creator.getName());
    }
}
