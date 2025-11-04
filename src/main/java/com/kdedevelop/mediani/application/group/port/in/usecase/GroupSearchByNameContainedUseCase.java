package com.kdedevelop.mediani.application.group.port.in.usecase;

import com.kdedevelop.mediani.application.group.port.in.command.GroupSearchByNameContainedCommand;
import com.kdedevelop.mediani.domain.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GroupSearchByNameContainedUseCase {
    Page<Group> searchGroupByNameContained(GroupSearchByNameContainedCommand command, Pageable pageable);
}
