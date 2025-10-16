package com.kdedevelop.mediani.user.adapter.in.web.controller;

import com.kdedevelop.mediani.user.application.port.in.usecase.UserLoginIdDuplicateCheckUseCase;
import com.kdedevelop.mediani.user.adapter.in.dto.UserRegisterRequest;
import com.kdedevelop.mediani.user.adapter.in.mapper.RegisterInBoundMapper;
import com.kdedevelop.mediani.user.application.port.in.usecase.UserRegisterUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/register/v0")
public class UserRegisterController {
    private final UserLoginIdDuplicateCheckUseCase userLoginIdDuplicateCheckUseCase;
    private final UserRegisterUseCase userRegisterUseCase;

    @GetMapping(value = "/id-duplicate-check/{loginId}")
    public boolean idDuplicationCheck(@PathVariable String loginId) {
        return userLoginIdDuplicateCheckUseCase.isDuplicate(loginId);
    }

    @PostMapping(value = "")
    public void create(@RequestBody UserRegisterRequest userRegisterRequest) {
        userRegisterUseCase.register(RegisterInBoundMapper.toCommand(userRegisterRequest));
    }
}
