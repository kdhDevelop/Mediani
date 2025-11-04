package com.kdedevelop.mediani.application.user.port.out;

import com.kdedevelop.mediani.domain.User;

public interface UserUpdateLockStatePort {
    void updateLockState(User user);
}
