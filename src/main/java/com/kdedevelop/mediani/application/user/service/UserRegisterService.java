package com.kdedevelop.mediani.application.user.service;

import com.kdedevelop.mediani.application.user.port.in.usecase.*;
import com.kdedevelop.mediani.application.user.port.in.command.*;
import com.kdedevelop.mediani.application.user.port.out.*;
import com.kdedevelop.mediani.domain.User;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserRegisterService implements UserRegisterUseCase, UserLoginIdDuplicateCheckUseCase {
    private final PasswordEncoder passwordEncoder;
    private final UserGenerateIdPort userGenerateIdPort;
    private final UserCreatePort userCreatePort;
    private final UserLoginIdDuplicateCheckPort userLoginIdDuplicateCheckPort;

    @Override
    @Transactional
    public void register(UserRegisterCommand command) {
        User user = new User(userGenerateIdPort.generateId(), command.loginId(), passwordEncoder.encode(command.password()), command.name(), command.expiredAt(), command.role());
        userCreatePort.create(user);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isDuplicate(String loginId) {
        return userLoginIdDuplicateCheckPort.isDuplicate(loginId);
    }
}
