package com.kdedevelop.mediani.application.group.port.out;

import com.kdedevelop.mediani.domain.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GroupSearchByNameContainedPort {
    Page<Group> searchGroupByNameContained(String name, Pageable pageable);
}
