package com.kdedevelop.mediani.application.type.port.out;

import com.kdedevelop.mediani.domain.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeSearchByNameContainedPort {
    Page<Type> searchByNameContained(String name, Pageable pageable);
}
