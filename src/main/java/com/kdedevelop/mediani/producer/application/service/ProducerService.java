package com.kdedevelop.mediani.producer.application.service;

import com.kdedevelop.mediani.producer.application.port.in.command.ProducerCreateCommand;
import com.kdedevelop.mediani.producer.application.port.in.command.ProducerReadCommand;
import com.kdedevelop.mediani.producer.application.port.in.command.ProducerSearchByNameContainedCommand;
import com.kdedevelop.mediani.producer.application.port.in.command.ProducerUpdateCommand;
import com.kdedevelop.mediani.producer.application.port.in.usecase.ProducerCreateUseCase;
import com.kdedevelop.mediani.producer.application.port.in.usecase.ProducerReadUseCase;
import com.kdedevelop.mediani.producer.application.port.in.usecase.ProducerSearchByNameContainedUseCase;
import com.kdedevelop.mediani.producer.application.port.in.usecase.ProducerUpdateUseCase;
import com.kdedevelop.mediani.producer.application.port.out.*;
import com.kdedevelop.mediani.producer.domain.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService implements ProducerCreateUseCase, ProducerReadUseCase, ProducerSearchByNameContainedUseCase, ProducerUpdateUseCase {
    private final ProducerCreatePort producerCreatePort;
    private final ProducerGenerateIdPort producerGenerateIdPort;
    private final ProducerReadPort producerReadPort;
    private final ProducerSearchByNameContainedPort producerSearchByNameContainedPort;
    private final ProducerUpdatePort producerUpdatePort;


    @Override
    public void create(ProducerCreateCommand command) {
        Producer producer = new Producer(producerGenerateIdPort.generateId(), command.name());
        producerCreatePort.create(producer);
    }

    @Override
    public Producer read(ProducerReadCommand command) {
        return producerReadPort.read(command.id());
    }

    @Override
    public Page<Producer> searchProducerByNameContained(ProducerSearchByNameContainedCommand command, Pageable pageable) {
        return producerSearchByNameContainedPort.searchProducerByNameContained(command.name(), pageable);
    }

    @Override
    public void update(ProducerUpdateCommand command) {
        Producer producer = producerReadPort.read(command.id());
        producer.update(command.name());
        producerUpdatePort.update(producer);
    }
}
