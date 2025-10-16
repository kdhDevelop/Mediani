package com.kdedevelop.mediani.user.application.port.out;

import com.kdedevelop.mediani.user.domain.User;

public interface UserUpdateLockStatePort {
    void updateLockState(User user);
}
