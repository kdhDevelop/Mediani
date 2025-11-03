package com.kdedevelop.mediani.user.adapter.out.mapper;

import com.kdedevelop.mediani.user.adapter.out.mybatis.UserMyBatisEntity;
import com.kdedevelop.mediani.user.domain.User;

public class UserOutBoundMapper {
    public static User toUser(UserMyBatisEntity userMyBatisEntity) {
        return new User(userMyBatisEntity.getId(), userMyBatisEntity.getLoginId(), userMyBatisEntity.getPassword(), userMyBatisEntity.getName(), userMyBatisEntity.getExpiredAt(), userMyBatisEntity.getCreatedAt(), userMyBatisEntity.getUpdatedAt(), userMyBatisEntity.isEnable(), userMyBatisEntity.isLock(), userMyBatisEntity.getRole());
    }

    public static UserMyBatisEntity toUserMyBatisEntity(User user) {
        return new UserMyBatisEntity(user.getId(), user.getLoginId(), user.getPassword(), user.getName(), user.getExpiredAt(), user.getCreatedAt(), user.getUpdatedAt(), user.isEnable(), user.isLock(), user.getRole());
    }
}
