package com.kdedevelop.mediani.application.user.port.out;

import com.kdedevelop.mediani.domain.User;

public interface UserReadByLoginIdPort {
    User readByLoginId(String loginId);
}
