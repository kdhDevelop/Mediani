package com.kdedevelop.mediani.producer.application.port.out;

import com.kdedevelop.mediani.producer.domain.Producer;

public interface ProducerReadPort {
    Producer read(long id);
}
