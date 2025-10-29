package com.kdedevelop.mediani.group.application.port.out;

import com.kdedevelop.mediani.group.domain.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GroupSearchByNameContainedPort {
    Page<Group> searchGroupByNameContained(String name, Pageable pageable);
}
