package com.kdedevelop.mediani.user.application.port.out;

import com.kdedevelop.mediani.user.domain.User;

public interface UserUpdateExpiredAtPort {
    void updateExpiredAt(User user);
}
