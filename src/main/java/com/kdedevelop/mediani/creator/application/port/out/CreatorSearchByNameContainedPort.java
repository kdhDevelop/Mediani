package com.kdedevelop.mediani.creator.application.port.out;

import com.kdedevelop.mediani.creator.domain.Creator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CreatorSearchByNameContainedPort {
    Page<Creator> searchCreatorByNameContained(String name, Pageable pageable);
}
