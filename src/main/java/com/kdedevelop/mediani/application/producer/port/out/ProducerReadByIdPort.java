package com.kdedevelop.mediani.application.producer.port.out;

import com.kdedevelop.mediani.domain.Producer;

import java.util.Optional;

public interface ProducerReadByIdPort {
    Optional<Producer> readById(long id);
}
