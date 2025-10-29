package com.kdedevelop.mediani.tag.application.port.in.usecase;

import com.kdedevelop.mediani.tag.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagSearchByNameContainedUseCase {
    Page<Tag> searchByNameContained(String name, Pageable pageable);
}
