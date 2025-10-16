package com.kdedevelop.mediani.user.adapter.in.mapper;

import com.kdedevelop.mediani.user.adapter.in.dto.UserRegisterRequest;
import com.kdedevelop.mediani.user.application.port.in.command.UserRegisterCommand;

public class RegisterInBoundMapper {
    public static UserRegisterCommand toCommand(UserRegisterRequest userRegisterRequest) {
        return new UserRegisterCommand(userRegisterRequest.loginId(), userRegisterRequest.password(), userRegisterRequest.name(), null, null);
    }
}
