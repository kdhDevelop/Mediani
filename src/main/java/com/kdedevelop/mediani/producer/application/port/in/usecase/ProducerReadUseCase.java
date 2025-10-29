package com.kdedevelop.mediani.producer.application.port.in.usecase;

import com.kdedevelop.mediani.producer.application.port.in.command.ProducerReadCommand;
import com.kdedevelop.mediani.producer.domain.Producer;

public interface ProducerReadUseCase {
    Producer read(ProducerReadCommand command);
}
