package com.kdedevelop.mediani.user.application.service;

import com.kdedevelop.mediani.user.application.port.in.command.UserDeleteCommand;
import com.kdedevelop.mediani.user.application.port.in.command.UserUpdateCommand;
import com.kdedevelop.mediani.user.application.port.in.command.UserUpdatePasswordCommand;
import com.kdedevelop.mediani.user.application.port.in.usecase.UserDeleteUseCase;
import com.kdedevelop.mediani.user.application.port.in.usecase.UserUpdatePasswordUseCase;
import com.kdedevelop.mediani.user.application.port.in.usecase.UserUpdateUseCase;
import com.kdedevelop.mediani.user.application.port.out.*;
import com.kdedevelop.mediani.user.domain.User;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService implements UserUpdateUseCase, UserUpdatePasswordUseCase, UserDeleteUseCase {
    private final PasswordEncoder passwordEncoder;
    private final UserFindByIdPort userFindByIdPort;
    private final UserUpdatePort userUpdatePort;
    private final UserUpdatePasswordPort userUpdatePasswordPort;
    private final UserDeletePort userDeletePort;

    @Override
    @Transactional
    public void update(UserUpdateCommand command) {
        User user = userFindByIdPort.findById(command.id());
        user.update(command.name());
        userUpdatePort.update(user);
    }

    @Override
    public void updatePassword(UserUpdatePasswordCommand command) {
        User user = userFindByIdPort.findById(command.id());
        String oldPassword = command.oldPassword();
        String newPassword = command.newPassword();

        if (!passwordEncoder.matches(oldPassword, user.getPassword())) throw new IllegalArgumentException("old password is wrong");

        String encodedNewPassword = passwordEncoder.encode(newPassword);
        user.updatePassword(encodedNewPassword);
        userUpdatePasswordPort.updatePassword(user);
    }

    @Override
    public void delete(UserDeleteCommand command) {
        User user = userFindByIdPort.findById(command.id());
        String password = command.password();

        if (!passwordEncoder.matches(password, user.getPassword())) throw new IllegalArgumentException("password is wrong");

        user.delete();
        userDeletePort.delete(user);
    }
}
