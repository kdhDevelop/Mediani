package com.kdedevelop.mediani.application.user.service;

import com.kdedevelop.mediani.application.user.port.in.command.*;
import com.kdedevelop.mediani.application.user.port.in.usecase.*;
import com.kdedevelop.mediani.application.user.port.out.*;
import com.kdedevelop.mediani.domain.User;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService implements UserUpdateUseCase, UserUpdatePasswordUseCase, UserDeleteUseCase, UserUpdateRoleUseCase, UserUpdateExpiredAtUseCase, UserUpdateLockStateUseCase {
    private final PasswordEncoder passwordEncoder;

    private final UserReadByIdPort userReadByIdPort;
    private final UserUpdatePort userUpdatePort;
    private final UserUpdatePasswordPort userUpdatePasswordPort;
    private final UserUpdateExpiredAtPort userUpdateExpiredAtPort;
    private final UserUpdateLockStatePort userUpdateLockStatePort;
    private final UserUpdateRolePort userUpdateRolePort;
    private final UserDeletePort userDeletePort;

    @Override
    @Transactional
    public void update(UserUpdateCommand command) {
        User user = userReadByIdPort.readById(command.id());
        user.update(command.name());
        userUpdatePort.update(user);
    }

    @Override
    @Transactional
    public void updatePassword(UserUpdatePasswordCommand command) {
        User user = userReadByIdPort.readById(command.id());
        String oldPassword = command.oldPassword();
        String newPassword = command.newPassword();

        if (!passwordEncoder.matches(oldPassword, user.getPassword())) throw new IllegalArgumentException("old password is wrong");

        String encodedNewPassword = passwordEncoder.encode(newPassword);
        user.updatePassword(encodedNewPassword);
        userUpdatePasswordPort.updatePassword(user);
    }

    @Override
    @Transactional
    public void delete(UserDeleteCommand command) {
        User user = userReadByIdPort.readById(command.id());
        String password = command.password();

        if (!passwordEncoder.matches(password, user.getPassword())) throw new IllegalArgumentException("password is wrong");

        user.delete();
        userDeletePort.delete(user);
    }

    @Override
    @Transactional
    public void updateExpiredAt(UserUpdateExpiredAtCommand command) {
        User user = userReadByIdPort.readById(command.id());
        LocalDateTime expiredAt = command.expiredAt();
        user.updateExpiredAt(expiredAt);
        userUpdateExpiredAtPort.updateExpiredAt(user);
    }

    @Override
    @Transactional
    public void updateLockState(UserUpdateLockStateCommand command) {
        User user = userReadByIdPort.readById(command.id());
        boolean lock = command.lock();
        user.updateLock(lock);
        userUpdateLockStatePort.updateLockState(user);
    }

    @Override
    @Transactional
    public void updateRole(UserUpdateRoleCommand command) {
        User user = userReadByIdPort.readById(command.id());
        User.Role role = command.role();
        user.updateRole(role);
        userUpdateRolePort.updateRole(user);
    }
}
