package com.kdedevelop.mediani.application.series.port.in.usecase;

import com.kdedevelop.mediani.application.series.port.in.command.SeriesSearchByNameContainedCommand;
import com.kdedevelop.mediani.domain.Series;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SeriesSearchByNameContainedUseCase {
    Page<Series> searchSeriesByNameContained(SeriesSearchByNameContainedCommand command, Pageable pageable);
}
