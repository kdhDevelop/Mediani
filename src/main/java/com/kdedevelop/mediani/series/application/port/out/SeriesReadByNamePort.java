package com.kdedevelop.mediani.series.application.port.out;

import com.kdedevelop.mediani.series.domain.Series;

import java.util.Optional;

public interface SeriesReadByNamePort {
    Optional<Series> readByName(String name);
}
