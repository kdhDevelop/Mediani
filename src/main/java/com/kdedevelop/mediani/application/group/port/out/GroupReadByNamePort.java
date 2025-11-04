package com.kdedevelop.mediani.application.group.port.out;

import com.kdedevelop.mediani.domain.Group;

import java.util.Optional;

public interface GroupReadByNamePort {
    Optional<Group> readByName(String name);
}
