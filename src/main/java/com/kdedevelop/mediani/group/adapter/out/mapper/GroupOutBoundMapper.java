package com.kdedevelop.mediani.group.adapter.out.mapper;

import com.kdedevelop.mediani.group.adapter.out.mongo.GroupMongoEntity;
import com.kdedevelop.mediani.group.domain.Group;

public class GroupOutBoundMapper {
    public static Group toGroup(GroupMongoEntity groupMongoEntity) {
        return new Group(groupMongoEntity.getId(), groupMongoEntity.getName());
    }

    public static GroupMongoEntity toGroupMongoEntity(Group group) {
        return new GroupMongoEntity(group.getId(), group.getName());
    }
}
