package com.kdedevelop.mediani.media.application.port.out;

import com.kdedevelop.mediani.producer.domain.Producer;
import com.kdedevelop.mediani.media.domain.Media;

public interface MediaUpdateProducerPort {
    void addProducer(Media media, Producer producer);
    void deleteProducer(Media media, Producer producer);
}
