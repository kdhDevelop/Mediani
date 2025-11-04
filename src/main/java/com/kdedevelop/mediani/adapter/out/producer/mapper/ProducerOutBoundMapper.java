package com.kdedevelop.mediani.adapter.out.producer.mapper;

import com.kdedevelop.mediani.adapter.out.producer.mybatis.ProducerMyBatisEntity;
import com.kdedevelop.mediani.domain.Producer;

public class ProducerOutBoundMapper {
    public static Producer toProducer(ProducerMyBatisEntity producerMyBatisEntity) {
        return new Producer(producerMyBatisEntity.getId(), producerMyBatisEntity.getName());
    }

    public static ProducerMyBatisEntity toProducerMyBatisEntity(Producer producer) {
        return new ProducerMyBatisEntity(producer.getId(), producer.getName());
    }
}
