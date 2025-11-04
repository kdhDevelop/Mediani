package com.kdedevelop.mediani.application.producer.port.in.usecase;

import com.kdedevelop.mediani.application.producer.port.in.command.ProducerCreateCommand;

public interface ProducerCreateUseCase {
    void create(ProducerCreateCommand command);
}
