package com.kdedevelop.mediani.application.producer.service;

import com.kdedevelop.mediani.application.producer.port.in.command.*;
import com.kdedevelop.mediani.application.producer.port.in.usecase.*;
import com.kdedevelop.mediani.application.producer.port.out.*;
import com.kdedevelop.mediani.domain.Producer;
import com.kdedevelop.mediani.common.EntityNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProducerService implements ProducerCreateUseCase, ProducerReadUseCase, ProducerSearchByNameContainedUseCase, ProducerUpdateUseCase, ProducerReadOrCreateByNameUseCase {
    private final ProducerCreatePort producerCreatePort;
    private final ProducerGenerateIdPort producerGenerateIdPort;
    private final ProducerReadByIdPort producerReadByIdPort;
    private final ProducerSearchByNameContainedPort producerSearchByNameContainedPort;
    private final ProducerUpdatePort producerUpdatePort;
    private final ProducerReadByNamePort producerReadByNamePort;


    @Override
    @Transactional
    public void create(ProducerCreateCommand command) {
        Producer producer = new Producer(producerGenerateIdPort.generateId(), command.name());
        producerCreatePort.create(producer);
    }

    @Override
    @Transactional(readOnly = true)
    public Producer read(ProducerReadCommand command) {
        return producerReadByIdPort.readById(command.id()).orElseThrow(() -> new EntityNotFoundException("producer id : " + command.id() + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Producer> searchProducerByNameContained(ProducerSearchByNameContainedCommand command, Pageable pageable) {
        return producerSearchByNameContainedPort.searchProducerByNameContained(command.name(), pageable);
    }

    @Override
    @Transactional
    public void update(ProducerUpdateCommand command) {
        Producer producer = producerReadByIdPort.readById(command.id()).orElseThrow(() -> new EntityNotFoundException("producer id : " + command.id() + " not found"));
        producer.update(command.name());
        producerUpdatePort.update(producer);
    }

    @Override
    @Transactional
    public Producer readOrCreateByName(ProducerReadOrCreateByNameCommand command) {
        Optional<Producer> producer = producerReadByNamePort.readByName(command.name());
        if (producer.isEmpty()) {
            try {
                producerCreatePort.create(new Producer(producerGenerateIdPort.generateId(), command.name()));
            } catch (Exception ignore) {}
            producer = producerReadByNamePort.readByName(command.name());
        }
        return producer.orElseThrow(() -> new IllegalStateException("producer name : " + command.name() + " not found"));
    }
}
