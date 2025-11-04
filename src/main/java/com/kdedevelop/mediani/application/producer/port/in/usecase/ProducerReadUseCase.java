package com.kdedevelop.mediani.application.producer.port.in.usecase;

import com.kdedevelop.mediani.application.producer.port.in.command.ProducerReadCommand;
import com.kdedevelop.mediani.domain.Producer;

public interface ProducerReadUseCase {
    Producer read(ProducerReadCommand command);
}
