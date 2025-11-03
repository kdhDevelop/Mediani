package com.kdedevelop.mediani.group.application.port.out;

import com.kdedevelop.mediani.group.domain.Group;

import java.util.Optional;

public interface GroupReadByIdPort {
    Optional<Group> readById(long id);
}
