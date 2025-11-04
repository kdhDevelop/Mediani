package com.kdedevelop.mediani.application.series.port.out;

import com.kdedevelop.mediani.domain.Series;

import java.util.Optional;

public interface SeriesReadByIdPort {
    Optional<Series> readById(long id);
}
