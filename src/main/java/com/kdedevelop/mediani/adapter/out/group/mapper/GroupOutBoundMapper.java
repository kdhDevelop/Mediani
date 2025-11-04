package com.kdedevelop.mediani.adapter.out.group.mapper;

import com.kdedevelop.mediani.adapter.out.group.mybatis.GroupMyBatisEntity;
import com.kdedevelop.mediani.domain.Group;

public class GroupOutBoundMapper {
    public static Group toGroup(GroupMyBatisEntity groupMyBatisEntity) {
        return new Group(groupMyBatisEntity.getId(), groupMyBatisEntity.getName());
    }

    public static GroupMyBatisEntity toGroupMyBatisEntity(Group group) {
        return new GroupMyBatisEntity(group.getId(), group.getName());
    }
}
