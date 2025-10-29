package com.kdedevelop.mediani.creator.application.port.in.usecase;

import com.kdedevelop.mediani.creator.application.port.in.command.CreatorSearchByNameContainedCommand;
import com.kdedevelop.mediani.creator.domain.Creator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CreatorSearchByNameContainedUseCase {
    Page<Creator> searchCreatorByNameContained(CreatorSearchByNameContainedCommand command, Pageable pageable);
}
