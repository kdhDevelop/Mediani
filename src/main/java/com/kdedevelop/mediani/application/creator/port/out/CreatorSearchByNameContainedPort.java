package com.kdedevelop.mediani.application.creator.port.out;

import com.kdedevelop.mediani.domain.Creator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CreatorSearchByNameContainedPort {
    Page<Creator> searchCreatorByNameContained(String name, Pageable pageable);
}
