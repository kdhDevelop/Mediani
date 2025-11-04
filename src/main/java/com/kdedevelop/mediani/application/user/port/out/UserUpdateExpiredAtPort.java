package com.kdedevelop.mediani.application.user.port.out;

import com.kdedevelop.mediani.domain.User;

public interface UserUpdateExpiredAtPort {
    void updateExpiredAt(User user);
}
