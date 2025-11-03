package com.kdedevelop.mediani.series.application.port.out;

import com.kdedevelop.mediani.series.domain.Series;

import java.util.Optional;

public interface SeriesReadByIdPort {
    Optional<Series> readById(long id);
}
