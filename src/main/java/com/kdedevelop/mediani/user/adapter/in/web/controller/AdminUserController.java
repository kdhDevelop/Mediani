package com.kdedevelop.mediani.user.adapter.in.web.controller;

import com.kdedevelop.mediani.user.adapter.in.mapper.UserInBoundMapper;
import com.kdedevelop.mediani.user.adapter.out.mapper.UserOutBoundMapper;
import com.kdedevelop.mediani.user.application.port.in.usecase.UserUpdateExpiredAtUseCase;
import com.kdedevelop.mediani.user.application.port.in.usecase.UserUpdateLockStateUseCase;
import com.kdedevelop.mediani.user.application.port.in.usecase.UserUpdateRoleUseCase;
import com.kdedevelop.mediani.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/admin/v0/user")
public class AdminUserController {
    private final UserUpdateExpiredAtUseCase userUpdateExpiredAtUseCase;
    private final UserUpdateRoleUseCase userUpdateRoleUseCase;
    private final UserUpdateLockStateUseCase userUpdateLockStateUseCase;

    @PutMapping(value = "/expired-at/{id}/{expiredAt}")
    public void updateExpiredAt(@PathVariable int id, @PathVariable LocalDateTime expiredAt) {
        userUpdateExpiredAtUseCase.updateExpiredAt(UserInBoundMapper.toUserUpdateExpiredAtCommand(id, expiredAt));
    }

    @PutMapping(value = "/role/{id}/{role}")
    public void updateRole(@PathVariable int id, @PathVariable User.Role role) {
        userUpdateRoleUseCase.updateRole(UserInBoundMapper.toUserUpdateRoleCommand(id, role));
    }

    @PutMapping(value = "/lock/{id}/{lock}")
    public void updateLock(@PathVariable int id, @PathVariable boolean lock) {
        userUpdateLockStateUseCase.updateLockState(UserInBoundMapper.toUserUpdateLockStateCommand(id, lock));
    }
}
