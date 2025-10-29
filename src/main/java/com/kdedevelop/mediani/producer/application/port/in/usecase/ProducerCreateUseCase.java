package com.kdedevelop.mediani.producer.application.port.in.usecase;

import com.kdedevelop.mediani.producer.application.port.in.command.ProducerCreateCommand;

public interface ProducerCreateUseCase {
    void create(ProducerCreateCommand command);
}
