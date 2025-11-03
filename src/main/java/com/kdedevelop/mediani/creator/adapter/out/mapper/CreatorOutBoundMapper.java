package com.kdedevelop.mediani.creator.adapter.out.mapper;

import com.kdedevelop.mediani.creator.adapter.out.mybatis.CreatorMyBatisEntity;
import com.kdedevelop.mediani.creator.domain.Creator;

public class CreatorOutBoundMapper {
    public static Creator toCreator(CreatorMyBatisEntity creatorMyBatisEntity) {
        return new Creator(creatorMyBatisEntity.getId(), creatorMyBatisEntity.getName());
    }

    public static CreatorMyBatisEntity toCreatorMyBatisEntity(Creator creator) {
        return new CreatorMyBatisEntity(creator.getId(), creator.getName());
    }
}
