package com.kdedevelop.mediani.adapter.out.creator.mapper;

import com.kdedevelop.mediani.adapter.out.creator.mybatis.CreatorMyBatisEntity;
import com.kdedevelop.mediani.domain.Creator;

public class CreatorOutBoundMapper {
    public static Creator toCreator(CreatorMyBatisEntity creatorMyBatisEntity) {
        return new Creator(creatorMyBatisEntity.getId(), creatorMyBatisEntity.getName());
    }

    public static CreatorMyBatisEntity toCreatorMyBatisEntity(Creator creator) {
        return new CreatorMyBatisEntity(creator.getId(), creator.getName());
    }
}
