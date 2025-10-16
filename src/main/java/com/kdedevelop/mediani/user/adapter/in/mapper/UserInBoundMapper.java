package com.kdedevelop.mediani.user.adapter.in.mapper;

import com.kdedevelop.mediani.user.adapter.in.dto.UserDeleteRequest;
import com.kdedevelop.mediani.user.adapter.in.dto.UserReadResponse;
import com.kdedevelop.mediani.user.adapter.in.dto.UserUpdatePasswordRequest;
import com.kdedevelop.mediani.user.adapter.in.dto.UserUpdateRequest;
import com.kdedevelop.mediani.user.application.port.in.command.*;
import com.kdedevelop.mediani.user.domain.User;

import java.time.LocalDateTime;

public class UserInBoundMapper {
    public static UserReadResponse toUserReadResponse(User user) {
        return new UserReadResponse(user.getId(), user.getLoginId(), user.getName(), user.getExpiredAt(), user.getCreatedAt(), user.getUpdatedAt(), user.getRole());
    }

    public static UserUpdateCommand toUserUpdateCommand(int id, UserUpdateRequest request) {
        return new UserUpdateCommand(id, request.name());
    }

    public static UserUpdatePasswordCommand toUserUpdatePasswordCommand(int id, UserUpdatePasswordRequest request) {
        return new UserUpdatePasswordCommand(id, request.oldPassword(), request.oldPassword(), request.confirmPassword());
    }

    public static UserDeleteCommand toUserDeleteCommand(int id, UserDeleteRequest request) {
        return new UserDeleteCommand(id, request.password());
    }

    public static UserUpdateRoleCommand toUserUpdateRoleCommand(int id, User.Role role) {
        return new UserUpdateRoleCommand(id, role);
    }

    public static UserUpdateExpiredAtCommand toUserUpdateExpiredAtCommand(int id, LocalDateTime expiredAt) {
        return new UserUpdateExpiredAtCommand(id, expiredAt);
    }

    public static UserUpdateLockStateCommand toUserUpdateLockStateCommand(int id, boolean lock) {
        return new UserUpdateLockStateCommand(id, lock);
    }
}
