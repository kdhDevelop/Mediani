package com.kdedevelop.mediani.producer.adapter.out.mapper;

import com.kdedevelop.mediani.producer.adapter.out.mybatis.ProducerMyBatisEntity;
import com.kdedevelop.mediani.producer.domain.Producer;

public class ProducerOutBoundMapper {
    public static Producer toProducer(ProducerMyBatisEntity producerMyBatisEntity) {
        return new Producer(producerMyBatisEntity.getId(), producerMyBatisEntity.getName());
    }

    public static ProducerMyBatisEntity toProducerMyBatisEntity(Producer producer) {
        return new ProducerMyBatisEntity(producer.getId(), producer.getName());
    }
}
