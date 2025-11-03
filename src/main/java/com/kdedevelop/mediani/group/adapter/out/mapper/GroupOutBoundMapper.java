package com.kdedevelop.mediani.group.adapter.out.mapper;

import com.kdedevelop.mediani.group.adapter.out.mybatis.GroupMyBatisEntity;
import com.kdedevelop.mediani.group.domain.Group;

public class GroupOutBoundMapper {
    public static Group toGroup(GroupMyBatisEntity groupMyBatisEntity) {
        return new Group(groupMyBatisEntity.getId(), groupMyBatisEntity.getName());
    }

    public static GroupMyBatisEntity toGroupMyBatisEntity(Group group) {
        return new GroupMyBatisEntity(group.getId(), group.getName());
    }
}
