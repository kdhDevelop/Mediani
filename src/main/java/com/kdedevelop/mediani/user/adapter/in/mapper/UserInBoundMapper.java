package com.kdedevelop.mediani.user.adapter.in.mapper;

import com.kdedevelop.mediani.user.adapter.in.dto.UserDeleteRequest;
import com.kdedevelop.mediani.user.adapter.in.dto.UserReadResponse;
import com.kdedevelop.mediani.user.adapter.in.dto.UserUpdatePasswordRequest;
import com.kdedevelop.mediani.user.adapter.in.dto.UserUpdateRequest;
import com.kdedevelop.mediani.user.application.port.in.command.UserDeleteCommand;
import com.kdedevelop.mediani.user.application.port.in.command.UserUpdateCommand;
import com.kdedevelop.mediani.user.application.port.in.command.UserUpdatePasswordCommand;
import com.kdedevelop.mediani.user.domain.User;

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
}
