package com.kdedevelop.mediani.user.application.service;

import com.kdedevelop.mediani.infrastructure.adapter.out.generator.IntegerIdGenerator;
import com.kdedevelop.mediani.user.application.port.in.command.UserRegisterCommand;
import com.kdedevelop.mediani.user.application.port.out.UserFindLatestIdPort;
import com.kdedevelop.mediani.user.application.port.in.usecase.UserLoginIdDuplicateCheckUseCase;
import com.kdedevelop.mediani.user.application.port.in.usecase.UserRegisterUseCase;
import com.kdedevelop.mediani.user.application.port.out.*;
import com.kdedevelop.mediani.user.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRegisterService implements UserRegisterUseCase, UserLoginIdDuplicateCheckUseCase {
    private final IntegerIdGenerator idGenerator;

    private final PasswordEncoder passwordEncoder;
    private final UserRegisterPort userRegisterPort;
    private final UserLoginIdDuplicateCheckPort userLoginIdDuplicateCheckPort;

    public UserRegisterService(@Autowired PasswordEncoder passwordEncoder, @Autowired UserRegisterPort userRegisterPort, @Autowired UserLoginIdDuplicateCheckPort userLoginIdDuplicateCheckPort, @Autowired UserFindLatestIdPort userFindLatestIdPort) {
        this.idGenerator = new IntegerIdGenerator(userFindLatestIdPort.getLastUserId() + 1);
        this.passwordEncoder = passwordEncoder;
        this.userRegisterPort = userRegisterPort;
        this.userLoginIdDuplicateCheckPort = userLoginIdDuplicateCheckPort;
    }

    @Override
    @Transactional
    public void register(UserRegisterCommand command) {
        User user = new User(idGenerator.generate(), command.loginId(), passwordEncoder.encode(command.password()), command.name(), command.expiredAt(), command.role());
        userRegisterPort.register(user);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isDuplicate(String loginId) {
        return userLoginIdDuplicateCheckPort.isDuplicate(loginId);
    }
}
