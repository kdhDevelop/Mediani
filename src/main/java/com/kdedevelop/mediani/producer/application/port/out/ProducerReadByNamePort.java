package com.kdedevelop.mediani.producer.application.port.out;

import com.kdedevelop.mediani.producer.domain.Producer;

import java.util.Optional;

public interface ProducerReadByNamePort {
    Optional<Producer> readByName(String name);
}
