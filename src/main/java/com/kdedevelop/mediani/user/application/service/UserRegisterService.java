package com.kdedevelop.mediani.user.application.service;

import com.kdedevelop.mediani.user.application.port.in.command.UserRegisterCommand;
import com.kdedevelop.mediani.user.application.port.out.UserGenerateIdPort;
import com.kdedevelop.mediani.user.application.port.in.usecase.UserLoginIdDuplicateCheckUseCase;
import com.kdedevelop.mediani.user.application.port.in.usecase.UserRegisterUseCase;
import com.kdedevelop.mediani.user.application.port.out.*;
import com.kdedevelop.mediani.user.domain.User;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserRegisterService implements UserRegisterUseCase, UserLoginIdDuplicateCheckUseCase {
    private final PasswordEncoder passwordEncoder;
    private final UserGenerateIdPort userGenerateIdPort;
    private final UserRegisterPort userRegisterPort;
    private final UserLoginIdDuplicateCheckPort userLoginIdDuplicateCheckPort;

    @Override
    @Transactional
    public void register(UserRegisterCommand command) {
        User user = new User(userGenerateIdPort.generateId(), command.loginId(), passwordEncoder.encode(command.password()), command.name(), command.expiredAt(), command.role());
        userRegisterPort.register(user);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isDuplicate(String loginId) {
        return userLoginIdDuplicateCheckPort.isDuplicate(loginId);
    }
}
