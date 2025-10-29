package com.kdedevelop.mediani.producer.application.port.out;

import com.kdedevelop.mediani.producer.domain.Producer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProducerSearchByNameContainedPort {
    Page<Producer> searchProducerByNameContained(String name, Pageable pageable);
}
