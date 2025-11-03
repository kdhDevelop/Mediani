package com.kdedevelop.mediani.group.application.port.out;

import com.kdedevelop.mediani.group.domain.Group;

import java.util.Optional;

public interface GroupReadByNamePort {
    Optional<Group> readByName(String name);
}
