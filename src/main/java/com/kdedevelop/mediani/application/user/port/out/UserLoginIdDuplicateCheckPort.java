package com.kdedevelop.mediani.application.user.port.out;

public interface UserLoginIdDuplicateCheckPort {
    boolean isDuplicate(String loginId);
}
