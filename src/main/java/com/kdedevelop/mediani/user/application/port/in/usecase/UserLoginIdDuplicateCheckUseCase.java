package com.kdedevelop.mediani.user.application.port.in.usecase;

public interface UserLoginIdDuplicateCheckUseCase {
    boolean isDuplicate(String loginId);
}
