package com.kdedevelop.mediani.user.application.port.out;

public interface UserLoginIdDuplicateCheckPort {
    boolean isDuplicate(String loginId);
}
