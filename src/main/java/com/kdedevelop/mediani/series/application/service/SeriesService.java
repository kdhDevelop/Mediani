package com.kdedevelop.mediani.series.application.service;

import com.kdedevelop.mediani.series.application.port.in.command.SeriesCreateCommand;
import com.kdedevelop.mediani.series.application.port.in.command.SeriesReadCommand;
import com.kdedevelop.mediani.series.application.port.in.command.SeriesSearchByNameContainedCommand;
import com.kdedevelop.mediani.series.application.port.in.command.SeriesUpdateCommand;
import com.kdedevelop.mediani.series.application.port.in.usecase.SeriesCreateUseCase;
import com.kdedevelop.mediani.series.application.port.in.usecase.SeriesReadUseCase;
import com.kdedevelop.mediani.series.application.port.in.usecase.SeriesSearchByNameContainedUseCase;
import com.kdedevelop.mediani.series.application.port.in.usecase.SeriesUpdateUseCase;
import com.kdedevelop.mediani.series.application.port.out.*;
import com.kdedevelop.mediani.series.domain.Series;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeriesService implements SeriesCreateUseCase, SeriesReadUseCase, SeriesSearchByNameContainedUseCase, SeriesUpdateUseCase {
    private final SeriesCreatePort seriesCreatePort;
    private final SeriesGenerateIdPort seriesGenerateIdPort;
    private final SeriesReadPort seriesReadPort;
    private final SeriesSearchByNameContainedPort seriesSearchByNameContainedPort;
    private final SeriesUpdatePort seriesUpdatePort;


    @Override
    public void create(SeriesCreateCommand command) {
        Series series = new Series(seriesGenerateIdPort.generateId(), command.name());
        seriesCreatePort.create(series);
    }

    @Override
    public Series read(SeriesReadCommand command) {
        return seriesReadPort.read(command.id());
    }

    @Override
    public Page<Series> searchSeriesByNameContained(SeriesSearchByNameContainedCommand command, Pageable pageable) {
        return seriesSearchByNameContainedPort.searchSeriesByNameContained(command.name(), pageable);
    }

    @Override
    public void update(SeriesUpdateCommand command) {
        Series series = seriesReadPort.read(command.id());
        series.update(command.name());
        seriesUpdatePort.update(series);
    }
}
