package com.kdedevelop.mediani.media.application.port.out;

import com.kdedevelop.mediani.series.domain.Series;
import com.kdedevelop.mediani.media.domain.Media;

public interface MediaUpdateSeriesPort {
    void addSeries(Media media, Series series);
    void deleteSeries(Media media, Series series);
}
