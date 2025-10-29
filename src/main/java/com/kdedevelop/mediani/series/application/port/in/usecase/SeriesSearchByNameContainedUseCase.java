package com.kdedevelop.mediani.series.application.port.in.usecase;

import com.kdedevelop.mediani.series.application.port.in.command.SeriesSearchByNameContainedCommand;
import com.kdedevelop.mediani.series.domain.Series;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SeriesSearchByNameContainedUseCase {
    Page<Series> searchSeriesByNameContained(SeriesSearchByNameContainedCommand command, Pageable pageable);
}
