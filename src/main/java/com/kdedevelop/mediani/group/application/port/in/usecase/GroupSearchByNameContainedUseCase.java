package com.kdedevelop.mediani.group.application.port.in.usecase;

import com.kdedevelop.mediani.group.application.port.in.command.GroupSearchByNameContainedCommand;
import com.kdedevelop.mediani.group.domain.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GroupSearchByNameContainedUseCase {
    Page<Group> searchGroupByNameContained(GroupSearchByNameContainedCommand command, Pageable pageable);
}
