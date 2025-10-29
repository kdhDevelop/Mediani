package com.kdedevelop.mediani.series.application.port.out;

import com.kdedevelop.mediani.series.domain.Series;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SeriesSearchByNameContainedPort {
    Page<Series> searchSeriesByNameContained(String name, Pageable pageable);
}
