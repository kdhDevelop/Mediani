package com.kdedevelop.mediani.application.producer.port.in.usecase;

import com.kdedevelop.mediani.application.producer.port.in.command.ProducerSearchByNameContainedCommand;
import com.kdedevelop.mediani.domain.Producer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProducerSearchByNameContainedUseCase {
    Page<Producer> searchProducerByNameContained(ProducerSearchByNameContainedCommand command, Pageable pageable);
}
