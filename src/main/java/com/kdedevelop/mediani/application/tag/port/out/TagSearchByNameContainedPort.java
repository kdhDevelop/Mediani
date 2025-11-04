package com.kdedevelop.mediani.application.tag.port.out;

import com.kdedevelop.mediani.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagSearchByNameContainedPort {
    Page<Tag> readByNameContained(String name, Pageable pageable);
}
