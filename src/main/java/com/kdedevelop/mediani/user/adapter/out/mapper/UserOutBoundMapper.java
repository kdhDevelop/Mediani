package com.kdedevelop.mediani.user.adapter.out.mapper;

import com.kdedevelop.mediani.user.adapter.out.jpa.UserJpaEntity;
import com.kdedevelop.mediani.user.domain.User;

public class UserOutBoundMapper {
    public static User toUser(UserJpaEntity userJpaEntity) {
        return new User(userJpaEntity.getId(), userJpaEntity.getLoginId(), userJpaEntity.getPassword(), userJpaEntity.getName(), userJpaEntity.getExpiredAt(), userJpaEntity.getCreatedAt(), userJpaEntity.getUpdatedAt(), userJpaEntity.isEnable(), userJpaEntity.isLock(), userJpaEntity.getRole());
    }

    public static UserJpaEntity toUserJpaEntity(User user) {
        return new UserJpaEntity(user.getId(), user.getLoginId(), user.getPassword(), user.getName(), user.getExpiredAt(), user.getCreatedAt(), user.getUpdatedAt(), user.isEnable(), user.isLock(), user.getRole());
    }
}
