package com.kdedevelop.mediani.application.user.port.out;

import com.kdedevelop.mediani.domain.User;

public interface UserReadByIdPort {
    User readById(int id);
}
