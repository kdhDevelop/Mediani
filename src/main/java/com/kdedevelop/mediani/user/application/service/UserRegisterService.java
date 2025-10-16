package com.kdedevelop.mediani.user.application.service;

import com.kdedevelop.mediani.user.application.port.in.command.UserRegisterCommand;
import com.kdedevelop.mediani.user.application.port.in.usecase.UserFindLatestIdUseCase;
import com.kdedevelop.mediani.user.application.port.in.usecase.UserLoginIdDuplicateCheckUseCase;
import com.kdedevelop.mediani.user.application.port.in.usecase.UserRegisterUseCase;
import com.kdedevelop.mediani.user.application.port.out.*;
import com.kdedevelop.mediani.user.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserRegisterService implements UserRegisterUseCase, UserLoginIdDuplicateCheckUseCase {
    private final PasswordEncoder passwordEncoder;
    private final UserRegisterPort userRegisterPort;
    private final UserLoginIdDuplicateCheckPort userLoginIdDuplicateCheckPort;
    private final AtomicInteger userIdGenerator;

    public UserRegisterService(@Autowired PasswordEncoder passwordEncoder, @Autowired UserRegisterPort userRegisterPort, @Autowired UserLoginIdDuplicateCheckPort userLoginIdDuplicateCheckPort, @Autowired UserFindLatestIdUseCase userFindLatestIdUseCase) {
        this.passwordEncoder = passwordEncoder;
        this.userRegisterPort = userRegisterPort;
        this.userLoginIdDuplicateCheckPort = userLoginIdDuplicateCheckPort;
        this.userIdGenerator = new AtomicInteger(userFindLatestIdUseCase.getLastUserId() + 1);
    }

    @Override
    @Transactional
    public void register(UserRegisterCommand command) {
        User user = new User(userIdGenerator.getAndAdd(1), command.loginId(), passwordEncoder.encode(command.password()), command.name(), command.expiredAt(), command.role());
        userRegisterPort.register(user);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isDuplicate(String loginId) {
        return userLoginIdDuplicateCheckPort.isDuplicate(loginId);
    }
}
