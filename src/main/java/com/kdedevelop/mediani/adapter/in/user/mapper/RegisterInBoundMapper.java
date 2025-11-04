package com.kdedevelop.mediani.adapter.in.user.mapper;

import com.kdedevelop.mediani.adapter.in.user.dto.UserRegisterRequest;
import com.kdedevelop.mediani.application.user.port.in.command.UserRegisterCommand;

public class RegisterInBoundMapper {
    public static UserRegisterCommand toCommand(UserRegisterRequest userRegisterRequest) {
        return new UserRegisterCommand(userRegisterRequest.loginId(), userRegisterRequest.password(), userRegisterRequest.name(), null, null);
    }
}
