package com.kdedevelop.mediani.user.adapter.in.web.controller;

import com.kdedevelop.mediani.auth.domain.Auth;
import com.kdedevelop.mediani.user.adapter.in.dto.*;
import com.kdedevelop.mediani.user.adapter.in.mapper.UserInBoundMapper;
import com.kdedevelop.mediani.user.application.port.in.usecase.*;

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
