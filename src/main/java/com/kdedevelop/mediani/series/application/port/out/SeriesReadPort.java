package com.kdedevelop.mediani.series.application.port.out;

import com.kdedevelop.mediani.series.domain.Series;

public interface SeriesReadPort {
    Series read(long id);
}
