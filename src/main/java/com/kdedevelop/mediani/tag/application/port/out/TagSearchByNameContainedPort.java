package com.kdedevelop.mediani.tag.application.port.out;

import com.kdedevelop.mediani.tag.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagSearchByNameContainedPort {
    Page<Tag> readByNameContained(String name, Pageable pageable);
}
