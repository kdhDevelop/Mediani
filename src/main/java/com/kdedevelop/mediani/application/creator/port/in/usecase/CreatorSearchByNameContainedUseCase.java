package com.kdedevelop.mediani.application.creator.port.in.usecase;

import com.kdedevelop.mediani.application.creator.port.in.command.CreatorSearchByNameContainedCommand;
import com.kdedevelop.mediani.domain.Creator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CreatorSearchByNameContainedUseCase {
    Page<Creator> searchCreatorByNameContained(CreatorSearchByNameContainedCommand command, Pageable pageable);
}
