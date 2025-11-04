package com.kdedevelop.mediani.application.producer.port.out;

import com.kdedevelop.mediani.domain.Producer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProducerSearchByNameContainedPort {
    Page<Producer> searchProducerByNameContained(String name, Pageable pageable);
}
