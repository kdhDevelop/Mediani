package com.kdedevelop.mediani.adapter.in.user.init;

import com.kdedevelop.mediani.application.user.port.in.command.UserRegisterCommand;
import com.kdedevelop.mediani.application.user.port.in.usecase.UserLoginIdDuplicateCheckUseCase;
import com.kdedevelop.mediani.application.user.port.in.usecase.UserRegisterUseCase;
import com.kdedevelop.mediani.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminAccountInit implements ApplicationRunner {
    private static final String LOGIN_ID = "ADMIN";
    private static final String PASSWORD = "Qwerty@233456";
    private static final String NAME = "ADMIN";

    private final UserLoginIdDuplicateCheckUseCase userLoginIdDuplicateCheckUseCase;
    private final UserRegisterUseCase userRegisterUseCase;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (!userLoginIdDuplicateCheckUseCase.isDuplicate(LOGIN_ID)) return;

        userRegisterUseCase.register(new UserRegisterCommand(LOGIN_ID, PASSWORD, NAME, null, User.Role.ADMIN));
    }
}
