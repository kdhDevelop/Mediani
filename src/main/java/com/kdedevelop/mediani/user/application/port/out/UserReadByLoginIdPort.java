package com.kdedevelop.mediani.user.application.port.out;

import com.kdedevelop.mediani.user.domain.User;

public interface UserReadByLoginIdPort {
    User readByLoginId(String loginId);
}
