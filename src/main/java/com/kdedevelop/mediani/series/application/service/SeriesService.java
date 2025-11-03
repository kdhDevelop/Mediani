package com.kdedevelop.mediani.series.application.service;

import com.kdedevelop.mediani.common.EntityNotFoundException;
import com.kdedevelop.mediani.series.application.port.in.command.*;
import com.kdedevelop.mediani.series.application.port.in.usecase.*;
import com.kdedevelop.mediani.series.application.port.out.*;
import com.kdedevelop.mediani.series.domain.Series;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeriesService implements SeriesCreateUseCase, SeriesReadUseCase, SeriesSearchByNameContainedUseCase, SeriesUpdateUseCase, SeriesReadOrCreateByNameUseCase {
    private final SeriesCreatePort seriesCreatePort;
    private final SeriesGenerateIdPort seriesGenerateIdPort;
    private final SeriesReadByIdPort seriesReadByIdPort;
    private final SeriesSearchByNameContainedPort seriesSearchByNameContainedPort;
    private final SeriesUpdatePort seriesUpdatePort;
    private final SeriesReadByNamePort seriesReadByNamePort;

    @Override
    @Transactional
    public void create(SeriesCreateCommand command) {
        Series series = new Series(seriesGenerateIdPort.generateId(), command.name());
        seriesCreatePort.create(series);
    }

    @Override
    @Transactional(readOnly = true)
    public Series read(SeriesReadCommand command) {
        return seriesReadByIdPort.readById(command.id()).orElseThrow(() -> new EntityNotFoundException("series id : " + command.id() + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Series> searchSeriesByNameContained(SeriesSearchByNameContainedCommand command, Pageable pageable) {
        return seriesSearchByNameContainedPort.searchSeriesByNameContained(command.name(), pageable);
    }

    @Override
    @Transactional
    public void update(SeriesUpdateCommand command) {
        Series series = seriesReadByIdPort.readById(command.id()).orElseThrow(() -> new EntityNotFoundException("series id : " + command.id() + " not found"));
        series.update(command.name());
        seriesUpdatePort.update(series);
    }

    @Override
    @Transactional
    public Series readOrCreateByName(SeriesReadOrCreateByNameCommand command) {
        Optional<Series> series = seriesReadByNamePort.readByName(command.name());
        if (series.isEmpty()) {
            try {
                seriesCreatePort.create(new Series(seriesGenerateIdPort.generateId(), command.name()));
            } catch (Exception ignore) {}
            series = seriesReadByNamePort.readByName(command.name());
        }
        return series.orElseThrow(() -> new IllegalStateException("series name : " + command.name() + " not found"));
    }
}
