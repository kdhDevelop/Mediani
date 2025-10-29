package com.kdedevelop.mediani.producer.adapter.out.mapper;

import com.kdedevelop.mediani.producer.adapter.out.mongo.ProducerMongoEntity;
import com.kdedevelop.mediani.producer.domain.Producer;

public class ProducerOutBoundMapper {
    public static Producer toProducer(ProducerMongoEntity producerMongoEntity) {
        return new Producer(producerMongoEntity.getId(), producerMongoEntity.getName());
    }

    public static ProducerMongoEntity toProducerMongoEntity(Producer producer) {
        return new ProducerMongoEntity(producer.getId(), producer.getName());
    }
}
