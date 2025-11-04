package com.kdedevelop.mediani.adapter.in.user.web.controller;

import com.kdedevelop.mediani.adapter.in.user.dto.UserDeleteRequest;
import com.kdedevelop.mediani.adapter.in.user.dto.UserReadResponse;
import com.kdedevelop.mediani.adapter.in.user.dto.UserUpdatePasswordRequest;
import com.kdedevelop.mediani.adapter.in.user.dto.UserUpdateRequest;
import com.kdedevelop.mediani.application.user.port.in.usecase.UserDeleteUseCase;
import com.kdedevelop.mediani.application.user.port.in.usecase.UserUpdatePasswordUseCase;
import com.kdedevelop.mediani.application.user.port.in.usecase.UserUpdateUseCase;
import com.kdedevelop.mediani.domain.Auth;
import com.kdedevelop.mediani.adapter.in.user.mapper.UserInBoundMapper;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/user/v0/user")
public class UserController {
    private final UserUpdateUseCase userUpdateUseCase;
    private final UserUpdatePasswordUseCase userUpdatePasswordUseCase;
    private final UserDeleteUseCase userDeleteUseCase;

    @GetMapping(value = "")
    public UserReadResponse read(@AuthenticationPrincipal Auth auth) {
        return UserInBoundMapper.toUserReadResponse(auth.getUser());
    }

    @PutMapping(value = "")
    public void update(@AuthenticationPrincipal Auth auth, @Autowired HttpServletRequest request, @RequestBody UserUpdateRequest userUpdateRequest) {
        userUpdateUseCase.update(UserInBoundMapper.toUserUpdateCommand(auth.getUser().getId(), userUpdateRequest));
        request.getSession().invalidate();
    }

    @PutMapping(value = "/password")
    public void updatePassword(@AuthenticationPrincipal Auth auth, @Autowired HttpServletRequest request, @RequestBody UserUpdatePasswordRequest userUpdatePasswordRequest) {
        userUpdatePasswordUseCase.updatePassword(UserInBoundMapper.toUserUpdatePasswordCommand(auth.getUser().getId(), userUpdatePasswordRequest));
        request.getSession().invalidate();
    }

    @DeleteMapping(value = "")
    public void delete(@AuthenticationPrincipal Auth auth, @Autowired HttpServletRequest request, @RequestBody UserDeleteRequest userDeleteRequest) {
        userDeleteUseCase.delete(UserInBoundMapper.toUserDeleteCommand(auth.getUser().getId(), userDeleteRequest));
        request.getSession().invalidate();
    }
}
