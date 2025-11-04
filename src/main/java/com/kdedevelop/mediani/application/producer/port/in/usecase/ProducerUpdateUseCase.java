package com.kdedevelop.mediani.application.producer.port.in.usecase;

import com.kdedevelop.mediani.application.producer.port.in.command.ProducerUpdateCommand;

public interface ProducerUpdateUseCase {
    void update(ProducerUpdateCommand command);
}
