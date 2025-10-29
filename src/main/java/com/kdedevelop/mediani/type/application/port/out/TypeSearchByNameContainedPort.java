package com.kdedevelop.mediani.type.application.port.out;

import com.kdedevelop.mediani.type.domain.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeSearchByNameContainedPort {
    Page<Type> searchByNameContained(String name, Pageable pageable);
}
