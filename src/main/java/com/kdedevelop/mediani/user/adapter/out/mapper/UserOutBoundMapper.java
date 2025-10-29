package com.kdedevelop.mediani.user.adapter.out.mapper;

import com.kdedevelop.mediani.user.adapter.out.jpa.UserMongoEntity;
import com.kdedevelop.mediani.user.domain.User;

public class UserOutBoundMapper {
    public static User toUser(UserMongoEntity userMongoEntity) {
        return new User(userMongoEntity.getId(), userMongoEntity.getLoginId(), userMongoEntity.getPassword(), userMongoEntity.getName(), userMongoEntity.getExpiredAt(), userMongoEntity.getCreatedAt(), userMongoEntity.getUpdatedAt(), userMongoEntity.isEnable(), userMongoEntity.isLock(), User.Role.valueOf(userMongoEntity.getRole()));
    }

    public static UserMongoEntity toUserJpaEntity(User user) {
        return new UserMongoEntity(user.getId(), user.getLoginId(), user.getPassword(), user.getName(), user.getExpiredAt(), user.getCreatedAt(), user.getUpdatedAt(), user.isEnable(), user.isLock(), user.getRole().name());
    }
}
