package com.kdedevelop.mediani.application.tag.port.in.usecase;

import com.kdedevelop.mediani.application.tag.port.in.command.TagSearchByNameContainedCommand;
import com.kdedevelop.mediani.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagSearchByNameContainedUseCase {
    Page<Tag> searchByNameContained(TagSearchByNameContainedCommand command, Pageable pageable);
}
