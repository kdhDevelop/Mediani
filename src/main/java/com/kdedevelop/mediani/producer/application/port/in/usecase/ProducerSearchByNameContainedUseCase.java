package com.kdedevelop.mediani.producer.application.port.in.usecase;

import com.kdedevelop.mediani.producer.application.port.in.command.ProducerSearchByNameContainedCommand;
import com.kdedevelop.mediani.producer.domain.Producer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProducerSearchByNameContainedUseCase {
    Page<Producer> searchProducerByNameContained(ProducerSearchByNameContainedCommand command, Pageable pageable);
}
