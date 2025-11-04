package com.kdedevelop.mediani.application.user.port.in.usecase;

public interface UserLoginIdDuplicateCheckUseCase {
    boolean isDuplicate(String loginId);
}
