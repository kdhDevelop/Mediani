package com.kdedevelop.mediani.application.producer.port.in.usecase;

import com.kdedevelop.mediani.application.producer.port.in.command.ProducerReadOrCreateByNameCommand;
import com.kdedevelop.mediani.domain.Producer;

public interface ProducerReadOrCreateByNameUseCase {
    Producer readOrCreateByName(ProducerReadOrCreateByNameCommand command);
}
