package com.kdedevelop.mediani.application.media.port.out;

import com.kdedevelop.mediani.domain.Producer;
import com.kdedevelop.mediani.domain.Media;

public interface MediaUpdateProducerPort {
    void addProducer(Media media, Producer producer);
    void deleteProducer(Media media, Producer producer);
}
