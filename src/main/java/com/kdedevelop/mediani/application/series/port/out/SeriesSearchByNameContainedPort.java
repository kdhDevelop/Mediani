package com.kdedevelop.mediani.application.series.port.out;

import com.kdedevelop.mediani.domain.Series;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SeriesSearchByNameContainedPort {
    Page<Series> searchSeriesByNameContained(String name, Pageable pageable);
}
