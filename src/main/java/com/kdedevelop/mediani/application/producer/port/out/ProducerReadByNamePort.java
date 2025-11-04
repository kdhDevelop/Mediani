package com.kdedevelop.mediani.application.producer.port.out;

import com.kdedevelop.mediani.domain.Producer;

import java.util.Optional;

public interface ProducerReadByNamePort {
    Optional<Producer> readByName(String name);
}
