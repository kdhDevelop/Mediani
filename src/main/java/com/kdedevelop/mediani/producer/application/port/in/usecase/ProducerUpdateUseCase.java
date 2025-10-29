package com.kdedevelop.mediani.producer.application.port.in.usecase;

import com.kdedevelop.mediani.producer.application.port.in.command.ProducerUpdateCommand;

public interface ProducerUpdateUseCase {
    void update(ProducerUpdateCommand command);
}
