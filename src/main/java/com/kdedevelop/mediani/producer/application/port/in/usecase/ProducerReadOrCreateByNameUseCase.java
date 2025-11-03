package com.kdedevelop.mediani.producer.application.port.in.usecase;

import com.kdedevelop.mediani.producer.application.port.in.command.ProducerReadOrCreateByNameCommand;
import com.kdedevelop.mediani.producer.domain.Producer;

public interface ProducerReadOrCreateByNameUseCase {
    Producer readOrCreateByName(ProducerReadOrCreateByNameCommand command);
}
